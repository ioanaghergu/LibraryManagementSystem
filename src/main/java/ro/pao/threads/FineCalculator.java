package ro.pao.threads;

import ro.pao.model.BookCopy;
import ro.pao.model.Loan;
import ro.pao.repository.impl.BookCopyRepositoryImpl;
import ro.pao.repository.impl.LoanRepositoryImpl;
import ro.pao.service.BookCopyService;
import ro.pao.service.BookCopyServiceImpl;
import ro.pao.service.LoanService;
import ro.pao.service.LoanServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FineCalculator {

    private static final double FINE_RATE = 10.0;

    private final LoanService loanService = new LoanServiceImpl(new LoanRepositoryImpl());
    private final BookCopyService copyService = new BookCopyServiceImpl(new BookCopyRepositoryImpl());

    public double calculateFine(UUID id_member) {

        List<Loan> loans = loanService.getLoansForMember(id_member);

        ExecutorService executorService = Executors.newFixedThreadPool(loans.size());

        FineCalculatorTask.totalFineValue = 0.0;

        for (Loan loan : loans) {
            executorService.execute(new FineCalculatorTask(loan));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return FineCalculatorTask.totalFineValue;
    }

    private class FineCalculatorTask implements Runnable {

        private final Loan loan;
        private static double totalFineValue = 0.0;

        public FineCalculatorTask(Loan loan) {
            this.loan = loan;
        }

        private synchronized void addToTotalFineValue(double value) {
            totalFineValue += value;
        }

        @Override
        public void run() {

            UUID id_copy = loan.getId_copy();

            Optional<BookCopy> copy = Optional.empty();

            try {
                copy = copyService.getById(id_copy);

            } catch (SQLException e) {
                e.printStackTrace();
            }

            LocalDate dueDate = copy.get().getDueDate();
            LocalDate returnDate = copy.get().getReturnDate();

            if (returnDate.isAfter(dueDate)) {
                int daysLate = (int) ChronoUnit.DAYS.between(dueDate, returnDate);
                double fineValue = daysLate * FINE_RATE;

                addToTotalFineValue(fineValue);
            }
        }
    }
}

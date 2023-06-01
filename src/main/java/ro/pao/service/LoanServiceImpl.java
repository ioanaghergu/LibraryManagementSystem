package ro.pao.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.model.Loan;
import ro.pao.repository.LoanRepository;
import ro.pao.service.LoanService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter

public non-sealed class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Override
    public Optional<Loan> getById(UUID id) throws SQLException {
        return loanRepository.getById(id);
    }

    @Override
    public void addOnlyOne(Loan loan) throws SQLException {
        loanRepository.addNewObject(loan);
    }

    @Override
    public void editById(UUID id, Loan loan) {
        loanRepository.editById(id, loan);
    }

    @Override
    public void removeById(UUID id) {
        loanRepository.deleteById(id);
    }

    @Override
    public List<Loan> getAllFromList() {
        return loanRepository.getAll();
    }

    @Override
    public void addAllFromGivenList(List<Loan> loans) {
        loanRepository.addAllFromGivenList(loans);
    }

    @Override
    public List<Loan> getLoansForMember(UUID id_member) {
        return loanRepository.getLoansForMember(id_member);
    }
}

package ro.pao.repository;

import ro.pao.model.Loan;

import java.util.List;
import java.util.UUID;

public interface LoanRepository extends Repository<Loan> {

    public List<Loan> getLoansForMember(UUID id_member);
}

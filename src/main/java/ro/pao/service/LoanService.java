package ro.pao.service;

import ro.pao.model.Loan;

import java.util.List;
import java.util.UUID;

public sealed interface LoanService extends Service<Loan> permits LoanServiceImpl {

    public List<Loan> getLoansForMember(UUID id_member);
}

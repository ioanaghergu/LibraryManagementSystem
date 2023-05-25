package ro.pao.service;

import ro.pao.model.Loan;

public sealed interface LoanService extends Service<Loan> permits LoanServiceImpl {
}

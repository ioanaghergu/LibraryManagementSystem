package ro.pao.mapper;

import ro.pao.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LoanMapper {
    private static final LoanMapper INSTANCE = new LoanMapper();

    private LoanMapper() {

    }

    public static LoanMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Loan> mapToLoan(ResultSet resultSet) throws SQLException {
        if(resultSet.next()) {
            return Optional.of(
                    Loan.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .id_issuer(UUID.fromString(resultSet.getString("id_issuer")))
                            .id_receiver(UUID.fromString(resultSet.getString("id_receiver")))
                            .id_member(UUID.fromString(resultSet.getString("id_member")))
                            .id_copy(UUID.fromString(resultSet.getString("id_copy")))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Loan> mapToLoanList(ResultSet resultSet) throws SQLException {
        List<Loan> loanList = new ArrayList<>();

        while(resultSet.next()) {
            loanList.add(
                    Loan.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .id_issuer(UUID.fromString(resultSet.getString("id_issuer")))
                            .id_receiver(UUID.fromString(resultSet.getString("id_receiver")))
                            .id_member(UUID.fromString(resultSet.getString("id_member")))
                            .id_copy(UUID.fromString(resultSet.getString("id_copy")))
                            .build()
            );

        }

        return loanList;
    }
}

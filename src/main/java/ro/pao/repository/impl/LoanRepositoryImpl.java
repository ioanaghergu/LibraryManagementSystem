package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.LoanMapper;
import ro.pao.model.Loan;
import ro.pao.repository.LoanRepository;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LoanRepositoryImpl implements LoanRepository {

    private static final LoanMapper loanMapper = LoanMapper.getInstance();

    @Override
    public Optional<Loan> getById(UUID id) {

        String selectSql = "SELECT * FROM LoaN WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            return loanMapper.mapToLoan(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void addNewObject(Loan loan) {

        String insertSql = "INSERT INTO Loan (id, id_issuer, id_receiver, id_member, id_copy) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {

            preparedStatement.setString(1, loan.getId().toString());
            preparedStatement.setString(2, loan.getId_issuer().toString());
            preparedStatement.setString(3, loan.getId_receiver().toString());
            preparedStatement.setString(4, loan.getId_member().toString());
            preparedStatement.setString(5, loan.getId_copy().toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override

    public void editById(UUID id, Loan loan) {

        String updateSql = "UPDATE Loan SET id_member=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {

            preparedStatement.setString(1, loan.getId_member().toString());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(UUID id) {

        String deleteSql = "DELETE FROM Loan WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {

            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Loan> getAll() {

        String selectSql = "SELECT * FROM Loan";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            return loanMapper.mapToLoanList(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Loan> loanList) {

        loanList.forEach(this::addNewObject);
    }
}

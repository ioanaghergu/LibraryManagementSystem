package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.BookCopyMapper;
import ro.pao.model.BookCopy;
import ro.pao.repository.BookCopyRepository;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class BookCopyRepositoryImpl implements BookCopyRepository {

    private static final BookCopyMapper copyMapper = BookCopyMapper.getInstance();

    @Override
    public Optional<BookCopy> getById(UUID id) {

        String selectSql = "SELECT * FROM BookCopy WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            return copyMapper.mapToBookCopy(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void addNewObject(BookCopy bookCopy) {

        String insertSql = "INSERT INTO BookCopy VALUES(?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {

            preparedStatement.setString(1, bookCopy.getStatus().toString());
            preparedStatement.setDate(2, Date.valueOf(bookCopy.getIssueDate()));
            preparedStatement.setDate(3, Date.valueOf(bookCopy.getDueDate()));
            preparedStatement.setDate(4, Date.valueOf(bookCopy.getReturnDate()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editById(UUID id, BookCopy bookCopy) {

        String updateSql = "UPDATE BookCopy SET status=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {

            preparedStatement.setString(1, bookCopy.getStatus().toString());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(UUID id) {

        String deleteSql = "DELETE FROM BookCopy WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {

            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BookCopy> getAll() {

        String selectSql = "SElECT * FROM BookCopy";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            return copyMapper.mapToBookCopyList(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<BookCopy> copies) {
        copies.forEach(this::addNewObject);
    }
}

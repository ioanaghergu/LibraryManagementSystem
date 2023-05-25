package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.BookCopyMapper;
import ro.pao.model.Book;
import ro.pao.model.BookCopy;
import ro.pao.repository.BookCopyRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class BookCopyRepositoryImpl implements BookCopyRepository {

    private static final BookCopyMapper copyMapper = BookCopyMapper.getInstance();

    @Override
    public Optional<BookCopy> getByTitle(String title) {

        String selectSql = "SELECT * FROM BookCopy WHERE title=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();

            return copyMapper.mapToBookCopy(resultSet).stream().findAny();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
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

        String insertSql = "INSERT INTO BookCopy (id, title, status, issueDate, dueDate, returnDate, id_author, genre, section) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {

            preparedStatement.setString(1, bookCopy.getId().toString());
            preparedStatement.setString(2, bookCopy.getTitle());
            preparedStatement.setString(3, bookCopy.getStatus().toString());
            preparedStatement.setString(7, bookCopy.getId_author().toString());
            preparedStatement.setString(8, bookCopy.getGenre().toString());
            preparedStatement.setString(9, bookCopy.getSection().toString());

            try {
                preparedStatement.setDate(4, bookCopy.getIssueDate() != null ? Date.valueOf(bookCopy.getIssueDate()) : null);
                preparedStatement.setDate(5, bookCopy.getDueDate() != null ? Date.valueOf(bookCopy.getDueDate()) : null);
                preparedStatement.setDate(6, bookCopy.getReturnDate() != null ? Date.valueOf(bookCopy.getReturnDate()) : null);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

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

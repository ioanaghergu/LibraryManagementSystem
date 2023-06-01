package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.LibrarianMapper;
import ro.pao.model.Librarian;
import ro.pao.repository.LibrarianRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LibrarianRepositoryImpl implements LibrarianRepository {

    private static final LibrarianMapper librarianMapper = LibrarianMapper.getInstance();

    @Override
    public Optional<Librarian> getById(UUID id) {

        String selectSql = "SELECT * FROM Librarian WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            return librarianMapper.mapToLibrarian(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void addNewObject(Librarian librarian) {

        String inserSql = "INSERT INTO Librarian (id, name, salary) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(inserSql)) {

            preparedStatement.setString(1, librarian.getId().toString());
            preparedStatement.setString(2, librarian.getName());
            preparedStatement.setDouble(3, librarian.getSalary());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editById(UUID id, Librarian librarian) {

        String updateSql = "UPDATE Librarian SET salary=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {

            preparedStatement.setDouble(1, librarian.getSalary());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(UUID id) {

        String deleteSql = "DELETE FROM Librarian WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {

            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Librarian> getAll() {

        String selectSql = "SELECT * FROM Librarian";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            return librarianMapper.mapToLibrarianList(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Librarian> librarians) {

        librarians.forEach(this::addNewObject);
    }


}

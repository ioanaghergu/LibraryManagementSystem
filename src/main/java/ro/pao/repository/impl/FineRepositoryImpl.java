package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.FineMapper;
import ro.pao.mapper.LibrarianMapper;
import ro.pao.model.Fine;
import ro.pao.repository.FineRepository;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FineRepositoryImpl implements FineRepository {

    private static final FineMapper fineMapper = FineMapper.getInstance();

    @Override
    public Optional<Fine> getById(UUID id) {

        String selectSql = "SELECT * FROM Fine WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            return fineMapper.mapToFine(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void addNewObject(Fine fine) {

        String inserSql = "INSERT INTO Fine VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(inserSql)) {

            preparedStatement.setString(1, fine.getId().toString());
            preparedStatement.setFloat(2, fine.getFineValue().floatValue());
            preparedStatement.setString(3, fine.getMember().getId().toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editById(UUID id, Fine fine) {

        String updateSql = "UPDATE Fine SET fineValue=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {

            preparedStatement.setFloat(1, fine.getFineValue().floatValue());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(UUID id) {

        String deleteSql = "DELETE FROM Fine WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {

            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Fine> getAll() {

        String selectSql = "SELECT * FROM Fine";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            return fineMapper.mapToFineList(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Fine> fines) {

        fines.forEach(this::addNewObject);
    }
}

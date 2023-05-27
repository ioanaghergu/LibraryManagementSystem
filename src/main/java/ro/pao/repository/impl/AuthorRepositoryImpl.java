package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.exceptions.ObjectNotFound;
import ro.pao.mapper.AuthorMapper;
import ro.pao.model.Author;
import ro.pao.repository.AuthorRepository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AuthorRepositoryImpl implements AuthorRepository {
    private static final AuthorMapper authorMapper = AuthorMapper.getInstance();

    @Override
    public Optional<Author> getByName(String name) throws ObjectNotFound {

        String selectSql = "SELECT * FROM Author WHERE name=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            Optional<Author> author = authorMapper.mapToAuthor(resultSet);

            if(author.isEmpty()) {
                throw new ObjectNotFound("Nu exista niciun autor cu acest nume.");
            }

            return author;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Author> getById(UUID id) {

        String selectSql = "SELECT * FROM Author WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            return authorMapper.mapToAuthor(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void addNewObject(Author author) {

        String insertSql = "INSERT INTO Author (id, name, email) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {

            preparedStatement.setString(1, author.getId().toString());
            preparedStatement.setString(2, author.getName());
            preparedStatement.setString(3, author.getEmail());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editById(UUID id, Author author) {

        String editNameSql = "UPDATE Author SET name=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(editNameSql)) {

            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(UUID id) {

        String deleteSql = "DELETE FROM Author WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {

            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Author> getAll() {

        String selectSql = "SELECT * FROM Author";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            return authorMapper.mapToAuthorList(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Author> authors) {

        authors.forEach(this::addNewObject);
    }

}



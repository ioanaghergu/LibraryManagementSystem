package ro.pao.service;

import ro.pao.model.Author;

import java.sql.SQLException;
import java.util.Optional;

public interface AuthorService extends Service<Author> {

    Optional<Author> getByName(String name) throws SQLException;
}

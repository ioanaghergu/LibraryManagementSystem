package ro.pao.service;

import ro.pao.exceptions.ObjectNotFound;
import ro.pao.model.Author;

import java.sql.SQLException;
import java.util.Optional;

public sealed interface AuthorService extends Service<Author> permits AuthorServiceImpl {

    Optional<Author> getByName(String name) throws SQLException ;
}

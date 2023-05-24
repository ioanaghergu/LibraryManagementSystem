package ro.pao.repository;

import ro.pao.model.Author;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;


public interface AuthorRepository extends Repository<Author> {

    Optional<Author> getByName(String name) throws SQLException;
}

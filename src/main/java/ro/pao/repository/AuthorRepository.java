package ro.pao.repository;

import ro.pao.exceptions.ObjectNotFound;
import ro.pao.model.Author;

import java.sql.SQLException;
import java.util.Optional;


public interface AuthorRepository extends Repository<Author> {

    Optional<Author> getByName(String name) throws SQLException, ObjectNotFound;
}

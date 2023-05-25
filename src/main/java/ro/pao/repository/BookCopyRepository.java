package ro.pao.repository;

import ro.pao.model.BookCopy;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public interface BookCopyRepository extends Repository<BookCopy> {
    Optional<BookCopy> getByTitle(String title) throws SQLException;
}

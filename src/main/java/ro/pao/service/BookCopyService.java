package ro.pao.service;

import ro.pao.model.Book;
import ro.pao.model.BookCopy;

import java.sql.SQLException;
import java.util.Optional;

public interface BookCopyService extends Service<BookCopy> {

    Optional<BookCopy> getByTitle(String title) throws SQLException;
}

package ro.pao.service;

import ro.pao.model.Book;
import ro.pao.model.BookCopy;

import java.sql.SQLException;
import java.util.Optional;

public sealed interface BookCopyService extends Service<BookCopy> permits BookCopyServiceImpl {

    Optional<BookCopy> getByTitle(String title) throws SQLException;
}

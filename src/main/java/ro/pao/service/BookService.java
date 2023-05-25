package ro.pao.service;

import ro.pao.model.Book;

import java.sql.SQLException;
import java.util.Optional;

public sealed interface BookService extends Service<Book> permits BookServiceImpl {

    Optional<Book> getByTitle(String Title) throws SQLException;
}

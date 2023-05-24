package ro.pao.service;

import ro.pao.model.Book;

import java.sql.SQLException;
import java.util.Optional;

public interface BookService extends Service<Book> {

    Optional<Book> getByTitle(String Title) throws SQLException;
}

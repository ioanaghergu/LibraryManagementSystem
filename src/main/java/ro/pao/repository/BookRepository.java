package ro.pao.repository;

import ro.pao.model.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends Repository<Book> {

    Optional<Book> getByTitle(String title) throws SQLException;

    public void addFromJson(Book book);

}

package ro.pao.service;

import ro.pao.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    Optional<Book> getByID(UUID id);

    Optional<Book> getByTitle(String title);

    List<Book> getAllFromList();

    List<Book> getAllByTitle(String title);

    void addOnlyOne(Book book);

    void removeBookById(UUID id);

    void editBookById(UUID id, Book book);

    void addAllFromGivenList(List<Book> bookList);

}
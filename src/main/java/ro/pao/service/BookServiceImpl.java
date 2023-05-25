package ro.pao.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.model.Book;
import ro.pao.repository.BookRepository;
import ro.pao.service.BookService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter

public non-sealed class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void addFromJson(Book book) {
        bookRepository.addFromJson(book);
    }

    @Override
    public Optional<Book> getById(UUID id) throws SQLException {
        return bookRepository.getById(id);
    }

    @Override
    public Optional<Book> getByTitle(String title) throws SQLException {
        return bookRepository.getByTitle(title);
    }

    @Override
    public void addOnlyOne(Book book) throws SQLException {
        bookRepository.addNewObject(book);
    }

    @Override
    public void editById(UUID id, Book book) {
        bookRepository.editById(id, book);
    }

    @Override
    public void removeById(UUID id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllFromList() {
        return bookRepository.getAll();
    }

    @Override
    public void addAllFromGivenList(List<Book> books) {
        bookRepository.addAllFromGivenList(books);
    }
}

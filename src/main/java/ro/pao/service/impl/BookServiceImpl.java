package ro.pao.service.impl;

import ro.pao.model.Book;
import ro.pao.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    private static List<Book> books = new ArrayList<>();

    @Override
    public Optional<Book> getByID(UUID id) {
        return books.stream()
                .filter(book -> id.equals(book.getId()))
                .findAny();
    }

    @Override
    public Optional<Book> getByTitle(String title) {
        return books.stream()
                .filter(book -> title.equals(book.getTitle()))
                .findAny();
    }

    @Override
    public List<Book> getAllFromList() {
        return books;
    }

    @Override
    public List<Book> getAllByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toList());
    }


    @Override
    public void addOnlyOne(Book book) {
        books.add(book);

    }

    @Override
    public void removeBookById(UUID id) {
        books = books.stream()
                .filter(book -> !id.equals(book.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void editBookById(UUID id, Book book) {
        removeBookById(id);
        addOnlyOne(book);

    }

    @Override
    public void addAllFromGivenList(List<Book> bookList) {
        books.addAll(bookList);
    }
}

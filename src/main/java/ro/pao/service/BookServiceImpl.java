package ro.pao.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.application.csv.CsvFormatter;
import ro.pao.application.csv.CsvWriter;
import ro.pao.model.Book;
import ro.pao.repository.BookRepository;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Getter

public non-sealed class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private static final Logger logger = Logger.getGlobal();

    private static final CsvFormatter CSV_FORMATTER = CsvFormatter.getInstance();

    private static final CsvWriter CSV_WRITER = CsvWriter.getInstance();

    Path auditPath = Paths.get("audit.csv");

    @Override
    public void addFromJson(Book book) {
        bookRepository.addFromJson(book);
    }

    @Override
    public Optional<Book> getById(UUID id) throws SQLException {

        Optional<Book> book = Optional.empty();

        try {
            book = bookRepository.getById(id);

            LogRecord record = new LogRecord(Level.INFO, "Retrieved book with ID: " + id);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }

        return book;
    }

    @Override
    public Optional<Book> getByTitle(String title) throws SQLException {

        Optional<Book> book = Optional.empty();

        try {
            book = bookRepository.getByTitle(title);

            LogRecord record = new LogRecord(Level.INFO, "Retrieved book by title: " + title);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }

        return book;
    }

    @Override
    public void addOnlyOne(Book book) throws SQLException {

        try {
            bookRepository.addNewObject(book);

            LogRecord record = new LogRecord(Level.INFO, "Added book with title: " + book.getTitle());

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    @Override
    public void editById(UUID id, Book book) {

        try {
            bookRepository.editById(id, book);

            LogRecord record = new LogRecord(Level.INFO, "Updated book with ID: " + id);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    @Override
    public void removeById(UUID id) {

        try {
            bookRepository.deleteById(id);

            LogRecord record = new LogRecord(Level.INFO, "Deleted book by ID: " + id);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

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

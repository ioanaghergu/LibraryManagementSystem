package ro.pao.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.application.csv.CsvFormatter;
import ro.pao.application.csv.CsvWriter;
import ro.pao.exceptions.ObjectNotFound;
import ro.pao.model.Author;
import ro.pao.repository.AuthorRepository;

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

public non-sealed class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private static final Logger logger = Logger.getGlobal();

    private static final CsvFormatter CSV_FORMATTER = CsvFormatter.getInstance();

    private static final CsvWriter CSV_WRITER = CsvWriter.getInstance();

    Path auditPath = Paths.get("audit.csv");


    @Override
    public Optional<Author> getById(UUID id) throws SQLException {

        Optional<Author> author = Optional.empty();

        try {
            author = authorRepository.getById(id);

            LogRecord record = new LogRecord(Level.INFO, "Retrieved author by ID: " + id);
            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());

        }

        return author;
    }

    @Override
    public Optional<Author> getByName(String name) throws SQLException, ObjectNotFound {

        Optional<Author> author = Optional.empty();

        try {
            author = authorRepository.getByName(name);

            LogRecord record = new LogRecord(Level.INFO, "Retrieved author by name: " + name);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (ObjectNotFound e) {

            logger.log(Level.WARNING, e.getMessage());

        } catch (Exception e) {

            logger.log(Level.SEVERE, e.getMessage());
        }

        return author;
    }

    @Override
    public void addOnlyOne(Author author) throws SQLException {

        try {
            authorRepository.addNewObject(author);

            LogRecord record = new LogRecord(Level.INFO, "Added new author: " + author.getName());

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    @Override
    public void editById(UUID id, Author author) {

        try {
            authorRepository.editById(id, author);

            LogRecord record = new LogRecord(Level.INFO, "Updated author with ID: " + id);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());

        }
    }

    @Override
    public void removeById(UUID id) {

        try {
            authorRepository.deleteById(id);

            LogRecord record = new LogRecord(Level.INFO, "Deleted author with ID: " + id);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public List<Author> getAllFromList() {
        return authorRepository.getAll();
    }

    @Override
    public void addAllFromGivenList(List<Author> authors) {
        authorRepository.addAllFromGivenList(authors);
    }

}

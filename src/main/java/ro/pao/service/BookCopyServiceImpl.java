package ro.pao.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.application.csv.CsvFormatter;
import ro.pao.application.csv.CsvWriter;
import ro.pao.model.BookCopy;
import ro.pao.repository.BookCopyRepository;

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

public non-sealed class BookCopyServiceImpl implements BookCopyService {

    private final BookCopyRepository copyRepository;

    private static final Logger logger = Logger.getGlobal();

    private static final CsvFormatter CSV_FORMATTER = CsvFormatter.getInstance();

    private static final CsvWriter CSV_WRITER = CsvWriter.getInstance();

    Path auditPath = Paths.get("audit.csv");

    @Override
    public Optional<BookCopy> getById(UUID id) throws SQLException {

        Optional<BookCopy> copy = Optional.empty();

        try {
            copy = copyRepository.getById(id);

            LogRecord record = new LogRecord(Level.INFO, "Retrieved copy with ID: " + id);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }

        return copy;
    }

    @Override
    public Optional<BookCopy> getByTitle(String title) throws SQLException {

        Optional<BookCopy> copy = Optional.empty();

        try {
            copy = copyRepository.getByTitle(title);

            LogRecord record = new LogRecord(Level.INFO, "Retrieved copy with title: " + title);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }

        return copy;
    }

    @Override
    public void addOnlyOne(BookCopy copy) throws SQLException {

        try {
            copyRepository.addNewObject(copy);

            LogRecord record = new LogRecord(Level.INFO, "Added copy with title: " + copy.getTitle());

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    @Override
    public void editById(UUID id, BookCopy copy) {

        try {
            copyRepository.editById(id, copy);

            LogRecord record = new LogRecord(Level.INFO, "Edited copy with ID: " + id);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    @Override
    public void removeById(UUID id) {

        try {
            copyRepository.deleteById(id);

            LogRecord record = new LogRecord(Level.INFO, "Deleted copy with ID: " + id);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    @Override
    public List<BookCopy> getAllFromList() {
        return copyRepository.getAll();
    }

    @Override
    public void addAllFromGivenList(List<BookCopy> copies) {
        copyRepository.addAllFromGivenList(copies);
    }
}

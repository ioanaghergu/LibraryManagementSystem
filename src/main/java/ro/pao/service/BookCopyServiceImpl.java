package ro.pao.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.model.Book;
import ro.pao.model.BookCopy;
import ro.pao.repository.BookCopyRepository;
import ro.pao.service.BookCopyService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Getter

public non-sealed class BookCopyServiceImpl implements BookCopyService {

    private final BookCopyRepository copyRepository;

    private static final Logger logger = Logger.getGlobal();

    @Override
    public Optional<BookCopy> getById(UUID id) throws SQLException {

        Optional<BookCopy> copy = Optional.empty();

        try {
            copy = copyRepository.getById(id);

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

        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }

        return copy;
    }

    @Override
    public void addOnlyOne(BookCopy copy) throws SQLException {
        copyRepository.addNewObject(copy);
    }

    @Override
    public void editById(UUID id, BookCopy copy) {
        copyRepository.editById(id, copy);
    }

    @Override
    public void removeById(UUID id) {
        copyRepository.deleteById(id);
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

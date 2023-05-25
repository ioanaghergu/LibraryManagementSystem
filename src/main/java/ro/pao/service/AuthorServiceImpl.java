package ro.pao.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.exceptions.ObjectNotFound;
import ro.pao.model.Author;
import ro.pao.repository.AuthorRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Getter

public non-sealed class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private static final Logger logger = Logger.getGlobal();

    @Override
    public Optional<Author> getById(UUID id) throws SQLException {

        Optional<Author> author = Optional.empty();

        try {
            author = authorRepository.getById(id);

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

        } catch (ObjectNotFound e) {

            logger.log(Level.WARNING, e.getMessage());

        } catch (Exception e) {

            logger.log(Level.SEVERE, e.getMessage());
        }

        return author;
    }

    @Override
    public void addOnlyOne(Author author) throws SQLException {
        authorRepository.addNewObject(author);
    }

    @Override
    public void editById(UUID id, Author author) {
        authorRepository.editById(id, author);
    }

    @Override
    public void removeById(UUID id) {
        authorRepository.deleteById(id);
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

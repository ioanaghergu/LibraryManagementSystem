package ro.pao.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.model.Author;
import ro.pao.repository.AuthorRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter

public non-sealed class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Optional<Author> getById(UUID id) throws SQLException {
        return authorRepository.getById(id);
    }

    @Override
    public Optional<Author> getByName(String name) throws SQLException {
        return authorRepository.getByName(name);
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

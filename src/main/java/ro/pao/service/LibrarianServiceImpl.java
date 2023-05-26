package ro.pao.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.model.Librarian;
import ro.pao.repository.LibrarianRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter

public non-sealed class LibrarianServiceImpl implements LibrarianService {

    private final LibrarianRepository librarianRepository;

    @Override
    public Optional<Librarian> getById(UUID id) throws SQLException {
        return librarianRepository.getById(id);
    }

    @Override
    public void addOnlyOne(Librarian librarian) throws SQLException {
        librarianRepository.addNewObject(librarian);
    }

    @Override
    public void editById(UUID id, Librarian librarian) {
        librarianRepository.editById(id, librarian);
    }

    @Override
    public void removeById(UUID id) {
        librarianRepository.deleteById(id);
    }

    @Override
    public List<Librarian> getAllFromList() {
        return librarianRepository.getAll();
    }

    @Override
    public void addAllFromGivenList(List<Librarian> librarians) {
        librarianRepository.addAllFromGivenList(librarians);
    }

}

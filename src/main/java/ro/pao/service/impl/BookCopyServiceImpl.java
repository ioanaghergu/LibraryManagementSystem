package ro.pao.service.impl;

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

@RequiredArgsConstructor
@Getter

public class BookCopyServiceImpl implements BookCopyService {

    private final BookCopyRepository copyRepository;

    @Override
    public Optional<BookCopy> getById(UUID id) throws SQLException {
        return copyRepository.getById(id);
    }

    @Override
    public Optional<BookCopy> getByTitle(String title) throws SQLException {
        return copyRepository.getByTitle(title);
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

package ro.pao.service;

import org.junit.jupiter.api.Test;
import ro.pao.model.Librarian;
import ro.pao.repository.LibrarianRepository;
import ro.pao.repository.impl.LibrarianRepositoryImpl;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibrarianServiceTest {

    @Test
    void whenLibrarian_thenIsAdd() throws SQLException {

        Librarian librarian = Librarian.builder()
                .id(UUID.randomUUID())
                .name("Alex Nedelcu")
                .salary(2700.0)
                .build();

        LibrarianRepository librarianRepository = mock(LibrarianRepositoryImpl.class);
        LibrarianService librarianService = new LibrarianServiceImpl(librarianRepository);

        when(librarianRepository.getById(librarian.getId())).thenReturn(Optional.of(librarian));

        librarianService.addOnlyOne(librarian);

        assertEquals(Optional.of(librarian), librarianService.getById(librarian.getId()));
    }
}

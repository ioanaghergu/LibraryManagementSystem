package ro.pao.service;

import org.junit.jupiter.api.Test;
import ro.pao.exceptions.ObjectNotFound;
import ro.pao.model.Author;
import ro.pao.model.Librarian;
import ro.pao.repository.AuthorRepository;
import ro.pao.repository.LibrarianRepository;
import ro.pao.repository.impl.AuthorRepositoryImpl;
import ro.pao.repository.impl.LibrarianRepositoryImpl;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthorServiceTest {

    @Test
    void whenAuthor_thenIsSearchedByName() throws SQLException, ObjectNotFound {
        Author author  = Author.builder()
                .id(UUID.randomUUID())
                .name("Sarah J. Mass")
                .build();

        AuthorRepository authorRepository = mock(AuthorRepositoryImpl.class);
        AuthorService authorService = new AuthorServiceImpl(authorRepository);

        when(authorRepository.getByName(author.getName())).thenReturn(Optional.of(author));

        authorService.addOnlyOne(author);

        assertEquals(Optional.of(author), authorService.getByName(author.getName()));
    }
}

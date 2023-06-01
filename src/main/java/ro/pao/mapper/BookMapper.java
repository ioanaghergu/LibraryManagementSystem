package ro.pao.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import ro.pao.model.Author;
import ro.pao.model.Book;
import ro.pao.model.Publisher;
import ro.pao.model.enums.Genre;
import ro.pao.model.enums.Section;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookMapper {

    private static final BookMapper INSTANCE = new BookMapper();

    private BookMapper() {

    }
    public static BookMapper getInstance() {
        return INSTANCE;
    }

    public Book mapJsonObjectToBook(JsonNode node) {

        return Book.builder()
                .title(node.get("title").asText())
                .build();
    }

    public Optional<Book> mapToBook(ResultSet resultSet) throws SQLException {
        if(resultSet.next()) {
            return Optional.of(
                    Book.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .title(resultSet.getString("title"))
                            .genre(Genre.valueOf(resultSet.getString("genre")))
                            .section(Section.valueOf(resultSet.getString("section")))
                            .id_author(UUID.fromString(resultSet.getString("id_author")))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

public List<Book> mapToBookList(ResultSet resultSet) throws SQLException {
        List<Book> bookList = new ArrayList<>();

        while(resultSet.next()) {
            bookList.add(
                    Book.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .title(resultSet.getString("title"))
                            .genre(Genre.valueOf(resultSet.getString("genre")))
                            .section(Section.valueOf(resultSet.getString("section")))
                            .id_author(UUID.fromString(resultSet.getString("id_author")))
                            .build()
            );
        }

        return bookList;
    }

}

package ro.pao.mapper;

import ro.pao.model.BookCopy;
import ro.pao.model.enums.Genre;
import ro.pao.model.enums.Section;
import ro.pao.model.enums.Status;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookCopyMapper {
    private static final BookCopyMapper INSTANCE = new BookCopyMapper();

    private BookCopyMapper() {

    }
    public static BookCopyMapper getInstance() {
        return INSTANCE;
    }

    public Optional<BookCopy> mapToBookCopy(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
                 return Optional.of(
                         BookCopy.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .title(resultSet.getString("title"))
                            .genre(Genre.valueOf(resultSet.getString("genre")))
                            .section(Section.valueOf(resultSet.getString("section")))
                            .status(Status.valueOf(resultSet.getString("status")))
                            .id_author(UUID.fromString(resultSet.getString("id_author")))
                            .issueDate(resultSet.getDate("issueDate") != null ?
                                    resultSet.getDate("issueDate").toLocalDate() : null)
                            .dueDate(resultSet.getDate("dueDate") != null ?
                                    resultSet.getDate("dueDate").toLocalDate() : null)
                            .returnDate(resultSet.getDate("returnDate") != null ?
                                    resultSet.getDate("returnDate").toLocalDate() : null)
                            .build()
                 );
        } else {
            return Optional.empty();
        }
    }

    public List<BookCopy> mapToBookCopyList(ResultSet resultSet) throws SQLException {

        List<BookCopy> bookCopyList = new ArrayList<>();

        while (resultSet.next()) {
            bookCopyList.add(
                    BookCopy.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .title(resultSet.getString("title"))
                            .genre(Genre.valueOf(resultSet.getString("genre")))
                            .section(Section.valueOf(resultSet.getString("section")))
                            .status(Status.valueOf(resultSet.getString("status")))
                            .id_author(UUID.fromString(resultSet.getString("id_author")))
                            .issueDate(resultSet.getDate("issueDate") != null ?
                                    resultSet.getDate("issueDate").toLocalDate() : null)
                            .dueDate(resultSet.getDate("dueDate") != null ?
                                    resultSet.getDate("dueDate").toLocalDate() : null)
                            .returnDate(resultSet.getDate("returnDate") != null ?
                                    resultSet.getDate("returnDate").toLocalDate() : null)
                            .build()
            );
        }

        return bookCopyList;
    }
}

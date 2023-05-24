package ro.pao.mapper;

import ro.pao.model.BookCopy;
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
                            .copyNumber(UUID.fromString(resultSet.getString("copy_number")))
                            .status(Status.valueOf(resultSet.getString("status")))
                            .issueDate(resultSet.getDate("issueDate").toLocalDate())
                            .dueDate(resultSet.getDate("dueDate").toLocalDate())
                            .returnDate(resultSet.getDate("returnDate").toLocalDate())
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
                            .copyNumber(UUID.fromString(resultSet.getString("copy_number")))
                            .status(Status.valueOf(resultSet.getString("status")))
                            .issueDate(resultSet.getDate("issueDate").toLocalDate())
                            .dueDate(resultSet.getDate("dueDate").toLocalDate())
                            .returnDate(resultSet.getDate("returnDate").toLocalDate())
                            .build()
            );
        }

        return bookCopyList;
    }
}

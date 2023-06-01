package ro.pao.mapper;

import ro.pao.model.Librarian;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LibrarianMapper {
    private static final LibrarianMapper INSTANCE = new LibrarianMapper();

    private LibrarianMapper() {

    }

    public static LibrarianMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Librarian> mapToLibrarian(ResultSet resultSet) throws SQLException {
        if(resultSet.next()) {
            return Optional.of(
                    Librarian.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .name(resultSet.getString("name"))
                            .salary(resultSet.getDouble("salary"))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Librarian> mapToLibrarianList(ResultSet resultSet) throws SQLException {
        List<Librarian> librarianList = new ArrayList<>();

        while(resultSet.next()) {
            librarianList.add(
                    Librarian.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .name(resultSet.getString("name"))
                            .salary(resultSet.getDouble("salary"))
                            .build()
            );
        }

        return librarianList;
    }
}

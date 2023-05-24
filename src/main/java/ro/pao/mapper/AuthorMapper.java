package ro.pao.mapper;


import ro.pao.model.Author;
import ro.pao.model.Location;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AuthorMapper {
    private static final AuthorMapper INSTANCE = new AuthorMapper();

    private AuthorMapper() {

    }

    public static AuthorMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Author> mapToAuthor(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Author.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .name(resultSet.getString("name"))
                            .email(resultSet.getString("email"))
                            .phoneNumber(resultSet.getString("email"))
                            .adress(Location.builder()
                                    .id(UUID.fromString(resultSet.getString("id_location")))
                                    .build())
                            .build()
            );

        } else {
            return Optional.empty();
        }
    }

    public List<Author> mapToAuthorList(ResultSet resultSet) throws SQLException {
        List<Author> authorList = new ArrayList<>();

        while (resultSet.next()) {
            authorList.add(
                    Author.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .name(resultSet.getString("name"))
                            .email(resultSet.getString("email"))
                            .phoneNumber(resultSet.getString("email"))
                            .adress(Location.builder()
                                    .id(UUID.fromString(resultSet.getString("id_location")))
                                    .build())
                            .build()
            );
        }

        return authorList;
    }
}

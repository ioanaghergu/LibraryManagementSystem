package ro.pao.mapper;

import ro.pao.model.Location;
import ro.pao.model.Publisher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public class PublisherMapper {
    private static final PublisherMapper INSTANCE = new PublisherMapper();

    private PublisherMapper() {

    }

    public static PublisherMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Publisher> mapToPublisher(ResultSet resultSet) throws SQLException {

        if(resultSet.next()) {
            return Optional.of(
                    Publisher.builder()
                            .name(resultSet.getString("name"))
                            .email(resultSet.getString("email"))
                            .adress(Location.builder()
                                    .id(UUID.fromString(resultSet.getString("id_location")))
                                    .build())
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }
}

package ro.pao.mapper;

import ro.pao.model.Location;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public class LocationMapper {
    private static final LocationMapper INSTANCE = new LocationMapper();

    private LocationMapper() {

    }

    public static LocationMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Location> mapToLocation(ResultSet resultSet) throws SQLException {
        if(resultSet.next()) {
            return Optional.of(
                    Location.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .country(resultSet.getString("country"))
                            .city(resultSet.getString("city"))
                            .street(resultSet.getString("street"))
                            .apartment(resultSet.getInt("aparment"))
                            .streetNumber(resultSet.getInt("streetNumeber"))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }
}

package ro.pao.mapper;

import ro.pao.model.Fine;
import ro.pao.model.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FineMapper {
    private static final FineMapper INSTANCE = new FineMapper();

    private FineMapper() {

    }

    public static FineMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Fine> mapToFine(ResultSet resultSet) throws SQLException {
        if(resultSet.next()) {
            return Optional.of(
                    Fine.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .fineValue(resultSet.getDouble("fineValue"))
                            .id_member(UUID.fromString(resultSet.getString("id_member")))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Fine> mapToFineList(ResultSet resultSet) throws SQLException {
        List<Fine> fineList = new ArrayList<>();

        while(resultSet.next()) {
            fineList.add(
                    Fine.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .fineValue(resultSet.getDouble("fineValue"))
                            .id_member(UUID.fromString(resultSet.getString("id_member")))
                            .build()
            );
        }

        return fineList;
    }
}

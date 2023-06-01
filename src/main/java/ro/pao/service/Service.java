package ro.pao.service;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;
import java.util.List;


public interface Service<T> {
    Optional<T> getById(UUID id) throws SQLException;

    List<T> getAllFromList();

    void addOnlyOne(T object) throws SQLException;

    void addAllFromGivenList(List<T> list);

    void removeById(UUID id);

    void editById(UUID id, T object);


}

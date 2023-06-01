package ro.pao.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Repository<T> {
    Optional<T> getById(UUID id) throws SQLException;

    void addNewObject(T object) throws SQLException;

    void editById(UUID id, T object);

    void deleteById(UUID id);

    List<T> getAll();

    void addAllFromGivenList(List<T> list);
}

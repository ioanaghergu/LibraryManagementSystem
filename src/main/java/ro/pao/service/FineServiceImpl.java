package ro.pao.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.model.Fine;
import ro.pao.repository.FineRepository;
import ro.pao.service.FineService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter

public non-sealed class FineServiceImpl implements FineService {

    private final FineRepository fineRepository;

    @Override
    public Optional<Fine> getById(UUID id) throws SQLException {
        return fineRepository.getById(id);
    }

    @Override
    public void addOnlyOne(Fine fine) throws SQLException {
        fineRepository.addNewObject(fine);
    }

    @Override
    public void editById(UUID id, Fine fine) {
        fineRepository.editById(id, fine);
    }

    @Override
    public void removeById(UUID id) {
        fineRepository.deleteById(id);
    }

    @Override
    public List<Fine> getAllFromList() {
        return fineRepository.getAll();
    }

    @Override
    public void addAllFromGivenList(List<Fine> fines) {
        fineRepository.addAllFromGivenList(fines);
    }
}

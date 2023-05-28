package net.pao.temaSpringBoot.service;

import net.pao.temaSpringBoot.model.Client;
import net.pao.temaSpringBoot.model.DTO.ClientDTO;
import net.pao.temaSpringBoot.model.DTO.mapper.ClientMapper;
import net.pao.temaSpringBoot.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    //private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        //this.clientMapper = clientMapper;
    }

    public Optional<Client> getClientById(UUID id) {
        return clientRepository.findById(id);
    }

    public void createClient(Client client) {
        clientRepository.save(client);
    }

    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(UUID id) {
        clientRepository.deleteById(id);
    }

}

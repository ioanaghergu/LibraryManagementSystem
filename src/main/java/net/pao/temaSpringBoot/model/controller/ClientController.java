package net.pao.temaSpringBoot.model.controller;


import net.pao.temaSpringBoot.model.Client;
import net.pao.temaSpringBoot.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client-id/{id}")
    public Optional<Client> getById(@PathVariable(name = "id") UUID id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/create-client")
    public void createClient(@RequestBody Client client) {
        clientService.createClient(client);
    }

    @PutMapping("/update-client/{id}")
    public void updateClient(@PathVariable(name = "id") UUID id, @RequestBody Client client) {
        client.setClientId(id);
        clientService.updateClient(client);
    }

    @DeleteMapping("/delete-client/{id}")
    public void deleteClient(@PathVariable(name = "id") UUID id) {
        clientService.deleteClient(id);
    }

    @PatchMapping("/update-client-name/{id}")
    public void updateClientName(@PathVariable(name = "id") UUID id, @RequestBody Client client) {
        Optional<Client> existingClient = clientService.getClientById(id);

        if(client.getLastName() != null) {
            existingClient.get().setLastName(client.getLastName());
        }

        clientService.updateClient(existingClient.get());

    }
}

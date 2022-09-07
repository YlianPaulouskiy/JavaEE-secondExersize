package edu.step.service;

import edu.step.model.Client;

import java.util.Set;

public interface ClientService {

    Client findOne(Long id);

    Set<Client> findAll();

    Client save(Client client);

    void remove(Long id);
}

package edu.step.dao;

import edu.step.model.Client;

import java.util.Optional;
import java.util.Set;

public interface ClientDao {

    Optional<Client> findOne(Long id);

    Set<Client> findAll();

    Optional<Client> save(Client client);

    void remove(Long id);

}

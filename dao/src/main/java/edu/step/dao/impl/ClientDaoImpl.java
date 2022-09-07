package edu.step.dao.impl;

import edu.step.model.Client;
import edu.step.dao.ClientDao;
import edu.step.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Component
public class ClientDaoImpl implements ClientDao {

    private final ClientRepository clientRepository;

    @Override
    public Optional<Client> findOne(Long id) {
        try {
            return clientRepository
                    .getClientSet()
                    .stream()
                    .filter(client -> client.getId().equals(id))
                    .findFirst();
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Set<Client> findAll() {
        return clientRepository.getClientSet();
    }

    @Override
    public Optional<Client> save(Client client) {
        try {
            clientRepository.getClientSet().add(client);
            return findOne(client.getId());
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {
        try {
            clientRepository.getClientSet().removeIf(client -> client.getId().equals(id));
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }
}

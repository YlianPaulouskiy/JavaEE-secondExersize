package edu.step.service.impl;

import edu.step.dao.ClientDao;
import edu.step.model.Client;
import edu.step.service.ClientService;
import edu.step.service.exception.ClientNotFoundException;
import edu.step.service.exception.ClientNotSaveException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;

    @Override
    public Client findOne(Long id) {
        return clientDao.findOne(id).orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public Set<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientDao.save(client).orElseThrow(ClientNotSaveException::new);
    }

    @Override
    public void remove(Long id) {
        clientDao.remove(id);
    }
}

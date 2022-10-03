package edu.step.service.impl;

import edu.step.dto.ClientDto;
import edu.step.mapper.ClientMapper;
import edu.step.repository.ClientRepository;
import edu.step.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto findOne(Long id) {
        return clientMapper.convert(
                clientRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("Client " + id + " not found")
                )
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientMapper.convertToAddressDtoList(clientRepository.findAll());
    }

    @Override
    public ClientDto save(ClientDto entity) {
        return clientMapper.convert(
                clientRepository.save(
                        clientMapper.convert(entity)
                )
        );
    }

    @Override
    public void remove(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Long getAmountClient() {
        return clientRepository.getAmountClients();
    }
}

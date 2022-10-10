package edu.step.service.impl;

import edu.step.dto.clientDto.ClientDto;
import edu.step.dto.clientDto.ClientDtoWithIdAndDate;
import edu.step.dto.clientDto.ClientPhoneDto;
import edu.step.entity.Client;
import edu.step.exception.EntityNotCorrectException;
import edu.step.mapper.ClientMapper;
import edu.step.mapper.PhoneMapper;
import edu.step.repository.ClientRepository;
import edu.step.repository.PhoneRepository;
import edu.step.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    @Override
    public ClientPhoneDto findById(Long id) {
        return clientMapper.convertToDtoWithPhones(clientRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Client with id : " + id + " not exist")
                ));
    }

    @Override
    public List<ClientPhoneDto> findAll() {
        return clientMapper.convertList(clientRepository.findAll());
    }

    @Override
    public void remove(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Client with id : " + id + " not exist");
        }
    }

    @Override
    public Long getAmountClients() {
        return clientRepository.getAmountClients();
    }

    @Override
    public ClientDtoWithIdAndDate addClient(ClientDto clientDto) {
        if (clientDto.getName().length() == 0 ||
                clientDto.getLastName().length() == 0 ||
                clientDto.getPatronymic().length() == 0) {
            throw new EntityNotCorrectException("Check input parameters");
        } else {
                Client client = clientMapper.convert(clientDto);
                client.setDateAdded(new Date());
                return clientMapper.convertToDtoWithId(client);
        }
    }

    @Override
    public ClientDtoWithIdAndDate changeInfoById(Long id, ClientDto clientDto) {
        if (clientDto.getName().length() == 0 ||
                clientDto.getLastName().length() == 0 ||
                clientDto.getPatronymic().length() == 0) {
            throw new EntityNotCorrectException("Check input parameters");
        } else {
            if (clientRepository.existsById(id)) {
                Client client = clientRepository.findById(id).get();
                client.setName(clientDto.getName());
                client.setLastName(clientDto.getLastName());
                client.setPatronymic(clientDto.getPatronymic());
                client.setDateUpdate(new Date());
                return clientMapper.convertToDtoWithId(client);
            } else {
                throw new EntityNotFoundException("Client with id : " + id + " not exist");
            }
        }
    }

}

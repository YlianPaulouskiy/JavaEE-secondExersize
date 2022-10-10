package edu.step.service;

import edu.step.dto.clientDto.ClientDto;
import edu.step.dto.clientDto.ClientDtoWithIdAndDate;
import edu.step.dto.clientDto.ClientPhoneDto;

public interface ClientService extends CrudOperationService<ClientPhoneDto> {

    Long getAmountClients();

    ClientDtoWithIdAndDate addClient(ClientDto clientDto);

    ClientDtoWithIdAndDate changeInfoById(Long id, ClientDto clientDto);

}

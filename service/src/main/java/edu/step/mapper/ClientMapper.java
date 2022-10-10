package edu.step.mapper;

import edu.step.dto.clientDto.ClientDto;
import edu.step.dto.clientDto.ClientDtoWithIdAndDate;
import edu.step.dto.clientDto.ClientPhoneDto;
import edu.step.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client convert(ClientDto clientDto);

    Client convert(ClientDtoWithIdAndDate clientDtoWithIdAndDate);

    Client convert(ClientPhoneDto clientPhoneDto);

    ClientDto convertToDto(Client client);

    ClientDtoWithIdAndDate convertToDtoWithId(Client client);

    ClientPhoneDto convertToDtoWithPhones(Client client);

    List<ClientPhoneDto> convertList(List<Client> clientList);
}

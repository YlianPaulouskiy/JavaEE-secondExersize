package edu.step.mapper;

import edu.step.dto.ClientDto;
import edu.step.model.Client;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClientMapper {

    ClientDto convert(Client client);

    Client convert(ClientDto clientDto);

    List<Client> convertToAddressList(List<ClientDto> clientDtoList);

    List<ClientDto> convertToAddressDtoList(List<Client> clientList);

    @AfterMapping
    default void linkPhone(@MappingTarget Client client) {
        if (client != null) {
            client.getPhoneList().forEach(phone -> phone.setClient(client));
        }
    }

    @AfterMapping
    default void linkAddress(@MappingTarget Client client) {
        if (client != null) {
            client.getAddress().setClient(client);
        }
    }

}

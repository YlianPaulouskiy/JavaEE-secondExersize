package edu.step.mapper;

import edu.step.dto.AddressDto;
import edu.step.model.Address;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AddressMapper {

    AddressDto convert(Address address);

    Address convert(AddressDto addressDto);

    List<Address> convertToAddressList(List<AddressDto> addressDtoList);

    List<AddressDto> convertToAddressDtoList(List<Address> addressList);

    @AfterMapping
    default void linkClient(@MappingTarget Address address) {
        if (address != null) {
            address.getClient().setAddress(address);
        }
    }

}

package edu.step.mapper;

import edu.step.dto.addressDto.AddressDto;
import edu.step.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address convert(AddressDto addressDto);

    AddressDto convert(Address address);

}

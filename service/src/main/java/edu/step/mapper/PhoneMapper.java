package edu.step.mapper;

import edu.step.dto.phoneDto.PhoneClientDto;
import edu.step.dto.phoneDto.PhoneDto;
import edu.step.dto.phoneDto.PhoneDtoWithIdAndTariff;
import edu.step.entity.Phone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    Phone convert(PhoneDto phoneDto);

    Phone convert(PhoneDtoWithIdAndTariff phoneDtoWithIdAndTariff);

    Phone convert(PhoneClientDto phoneClientDto);

    PhoneDto convertToDto(Phone phone);

    PhoneDtoWithIdAndTariff convertToDtoWithId(Phone phone);

    PhoneClientDto convertToDtoWithClient(Phone phone);

    List<PhoneClientDto> convertList(List<Phone> phoneList);

}

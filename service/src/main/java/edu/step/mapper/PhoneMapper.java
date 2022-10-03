package edu.step.mapper;

import edu.step.dto.PhoneDto;
import edu.step.model.Phone;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PhoneMapper {

    PhoneDto convert(Phone phone);

    Phone convert(PhoneDto phoneDto);

    List<Phone> convertToAddressList(List<PhoneDto> phoneDtoList);

    List<PhoneDto> convertToAddressDtoList(List<Phone> phoneList);

    //добавляем зависимости
    @AfterMapping
    default void linkClient(@MappingTarget Phone phone) {
        if (phone != null) {
            phone.getClient().getPhoneList().add(phone);
        }
    }

}

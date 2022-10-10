package edu.step.mapper;

import edu.step.dto.tariffDto.TariffDto;
import edu.step.dto.tariffDto.TariffDtoWithId;
import edu.step.entity.Tariff;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TariffMapper {

    Tariff convert(TariffDto tariffDto);

    Tariff convert(TariffDtoWithId tariffDtoWithId);

    TariffDto convertToDto(Tariff tariff);

    TariffDtoWithId convertToDtoWithId(Tariff tariff);

    List<TariffDtoWithId> convertListWithId(List<Tariff> tariffList);

    List<TariffDto> convertList(List<Tariff> tariffList);

}

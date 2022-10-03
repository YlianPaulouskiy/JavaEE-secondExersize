package edu.step.mapper;

import edu.step.dto.TariffDto;
import edu.step.model.tariff.Tariff;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TariffMapper {

    Tariff convert(TariffDto tariffDto);

    TariffDto convert (Tariff tariff);

}

package edu.step.service;

import edu.step.dto.tariffDto.TariffDto;
import edu.step.dto.tariffDto.TariffDtoWithId;
import edu.step.entity.Tariff;

import java.util.List;

public interface TariffService extends CrudOperationService<TariffDtoWithId> {

    List<TariffDto> sortTariffByPrice();

    Tariff findTariffByParameters(Double priceFrom, Double priceTo,
                                  Integer minutesFrom, Integer minutesTo,
                                  Integer megabytesFrom, Integer megabytesTo);

}

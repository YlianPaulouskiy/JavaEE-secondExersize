package edu.step.service;

import edu.step.dto.PhoneDto;
import edu.step.dto.TariffDto;
import edu.step.service.basic.BaseService;

import java.util.List;

public interface PhoneService extends BaseService<PhoneDto> {

    TariffDto getTariff(Double price, Integer minutes, Integer megaBytes);

    List<PhoneDto> sortByTariffPrice(Double price);

}
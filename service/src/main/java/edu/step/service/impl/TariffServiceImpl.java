package edu.step.service.impl;

import edu.step.dto.tariffDto.TariffDto;
import edu.step.dto.tariffDto.TariffDtoWithId;
import edu.step.entity.Tariff;
import edu.step.mapper.TariffMapper;
import edu.step.repository.TariffRepository;
import edu.step.service.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;
    private final TariffMapper tariffMapper;


    @Override
    public TariffDtoWithId findById(Long id) {
        return tariffMapper.convertToDtoWithId(tariffRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Tariff with id: " + id + " not exist")
                ));
    }

    @Override
    public List<TariffDtoWithId> findAll() {
        return tariffMapper.convertListWithId(tariffRepository.findAll());
    }

    @Override
    public void remove(Long id) {
        if (tariffRepository.existsById(id)) {
            tariffRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Tariff with id: " + id + " not exist");
        }
    }

    @Override
    public List<TariffDto> sortTariffByPrice() {
        List<Tariff> tariffList = tariffRepository.findAll();
        tariffList.sort(Comparator.comparing(Tariff::getPrice));
        return tariffMapper.convertList(tariffList);
    }

    @Override
    public Tariff findTariffByParameters(Double priceFrom, Double priceTo, Integer minutesFrom, Integer minutesTo, Integer megabytesFrom, Integer megabytesTo) {
        return tariffRepository.findByPriceBetweenAndMinutesBetweenAndMegabytesBetween(
                priceFrom, priceTo,
                minutesFrom,minutesTo,
                megabytesFrom, megabytesTo
        );
    }
}

package edu.step.service.impl;

import edu.step.dto.PhoneDto;
import edu.step.dto.TariffDto;
import edu.step.mapper.PhoneMapper;
import edu.step.repository.PhoneRepository;
import edu.step.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    @Override
    public PhoneDto findOne(Long id) {
        return phoneMapper.convert(
                phoneRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("Phone " + id + " not found")
                )
        );
    }

    @Override
    public List<PhoneDto> findAll() {
        return phoneMapper.convertToAddressDtoList(phoneRepository.findAll());
    }

    @Override
    public PhoneDto save(PhoneDto entity) {
        return phoneMapper.convert(
                phoneRepository.save(
                        phoneMapper.convert(entity)
                )
        );
    }

    @Override
    public void remove(Long id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public TariffDto getTariff(Double price, Integer minutes, Integer megaBytes) {
        List<PhoneDto> phones = findAll();
        List<Double> avgPrice = new ArrayList<>();
        List<Integer> avgMinutes = new ArrayList<>();
        List<Integer> avgBytes = new ArrayList<>();
        for (PhoneDto phone : phones) {
            avgPrice.add(Math.abs(price - phone.getTariff().getPrice()));
            avgMinutes.add(Math.abs(minutes - phone.getTariff().getMinutes()));
            avgBytes.add(Math.abs(megaBytes - phone.getTariff().getMegaBytes()));
        }

        double minPriceAvg = Collections.min(avgPrice);
        int minMinutesAvg = Collections.min(avgMinutes);
        int minBytesAvg = Collections.min(avgBytes);

        if (minPriceAvg == 0) {
            if (minMinutesAvg == 0) {
                return phones.get(avgBytes.indexOf(minBytesAvg)).getTariff();
            }
            return phones.get(avgMinutes.indexOf(minMinutesAvg)).getTariff();
        }
        return phones.get(avgPrice.indexOf(minPriceAvg)).getTariff();
    }

    @Override
    public List<PhoneDto> sortByTariffPrice(Double price) {
        List<PhoneDto> phones = findAll();
        phones.sort(Comparator.comparing(phoneDto -> phoneDto.getTariff().getPrice()));
        return phones;
    }
}

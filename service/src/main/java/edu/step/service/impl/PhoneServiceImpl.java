package edu.step.service.impl;

import edu.step.dto.phoneDto.PhoneClientDto;
import edu.step.mapper.PhoneMapper;
import edu.step.repository.PhoneRepository;
import edu.step.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    @Override
    public PhoneClientDto findById(Long id) {
        return phoneMapper.convertToDtoWithClient(phoneRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Phone with id: " + id + " not exist")
                ));
    }

    @Override
    public List<PhoneClientDto> findAll() {
        return phoneMapper.convertList(phoneRepository.findAll());
    }

    @Override
    public void remove(Long id) {
        if (phoneRepository.existsById(id)) {
            phoneRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Phone with id: " + id + " not exist");
        }
    }
}

package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.ResidentDTO;
import ru.aston.mcs.mapper.ResidentMapper;
import ru.aston.mcs.repository.ResidentRepository;
import ru.aston.mcs.service.ResidentService;

import java.util.List;

@Service
@Transactional
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;
    private final ResidentMapper residentMapper;

    public ResidentServiceImpl(ResidentRepository residentRepository, ResidentMapper residentMapper) {
        this.residentRepository = residentRepository;
        this.residentMapper = residentMapper;
    }

    @Override
    public List<ResidentDTO> getAllResident() {
        return residentMapper.toDTOList(residentRepository.findAll());
    }

    @Override
    public ResidentDTO getResident(Long id) {
        return residentMapper.toDTO(residentRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public void createResident(ResidentDTO userDto) {
        residentRepository.save(residentMapper.toModel(userDto));
    }

    @Override
    public void deleteResident(Long id) {
        residentRepository.deleteById(id);
    }
}

package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.ResidentPassportDTO;
import ru.aston.mcs.mapper.ResidentPassportMapper;
import ru.aston.mcs.repository.ResidentPassportRepository;
import ru.aston.mcs.service.ResidentPassportService;

import java.util.List;

@Service
@Transactional
public class ResidentPassportServiceImpl implements ResidentPassportService {

    private final ResidentPassportRepository userPassportDataRepository;

    private final ResidentPassportMapper userPassportDataMapper;

    public ResidentPassportServiceImpl(ResidentPassportRepository userPassportDataRepository, ResidentPassportMapper userPassportDataMapper) {
        this.userPassportDataRepository = userPassportDataRepository;
        this.userPassportDataMapper = userPassportDataMapper;
    }

    @Override
    public List<ResidentPassportDTO> getAllUserPassportDatas() {
        return userPassportDataMapper.toDTOList(
                userPassportDataRepository.findAll());
    }

    @Override
    public void addAndSaveUserPassportData(ResidentPassportDTO userPassportDataDTO) {
        userPassportDataRepository.save(
                userPassportDataMapper.toModel(userPassportDataDTO));
    }

    @Override
    public void deleteUserPassportData(String userPassportDataId) {
        userPassportDataRepository.deleteById(userPassportDataId);
    }

    @Override
    public ResidentPassportDTO getUserPassportData(String userPassportDataId) {
        return userPassportDataMapper.toDTO(
                userPassportDataRepository.findById(userPassportDataId)
                        .orElseThrow(RuntimeException::new));
    }
}

package ru.aston.mcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.HousekeeperDTO;
import ru.aston.mcs.mapper.HousekeeperMapper;
import ru.aston.mcs.repository.HousekeeperRepository;
import ru.aston.mcs.service.HousekeeperService;

@Service
@Transactional
public class HousekeeperServiceImpl implements HousekeeperService {

    @Autowired
    HousekeeperRepository housekeeperRepository;

    @Autowired
    private HousekeeperMapper housekeeperMapper;

    @Override
    public void addAndSaveHousekeeper(HousekeeperDTO housekeeperDTO) {
        housekeeperRepository.save(housekeeperMapper.housekeeperDtoInHousekeeper(housekeeperDTO));
    }

    @Override
    public void deleteHousekeeper(Long housekeeperId) {
        housekeeperRepository.deleteById(housekeeperId);
    }

    @Override
    public HousekeeperDTO getHousekeeper(Long housekeeperId) {
        return housekeeperMapper.housekeeperInHousekeeperDto(housekeeperRepository.findById(housekeeperId).orElseThrow(RuntimeException::new));
    }
}

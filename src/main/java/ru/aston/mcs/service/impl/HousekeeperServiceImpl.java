package ru.aston.mcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.mcs.repository.HousekeeperRepository;
import ru.aston.mcs.dto.HousekeeperDTO;
import ru.aston.mcs.mapper.HousekeeperMapper;
import ru.aston.mcs.service.HousekeeperService;

@Service
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
    public void deleteHousekeeper(int housekeeperId) {
        housekeeperRepository.deleteById(housekeeperId);
    }

    @Override
    public HousekeeperDTO getHousekeeper(int housekeeperId) {
        return housekeeperMapper.housekeeperInHousekeeperDto(housekeeperRepository.findById(housekeeperId).orElseThrow(RuntimeException::new));
    }
}

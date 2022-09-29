package ru.aston.mcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dao.HousekeeperRepository;
import ru.aston.mcs.dto.HousekeeperDTO;
import ru.aston.mcs.entity.Housekeeper;
import ru.aston.mcs.mapper.HousekeeperMapper;
import ru.aston.mcs.service.HousekeeperService;

import java.util.List;
import java.util.Optional;

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

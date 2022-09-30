package ru.aston.mcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.entity.Housekeeper;
import ru.aston.mcs.repository.HousekeeperRepository;
import ru.aston.mcs.dto.HousekeeperDTO;
import ru.aston.mcs.mapper.HousekeeperMapper;
import ru.aston.mcs.service.HousekeeperService;

import java.util.List;

@Service
public class HousekeeperServiceImpl implements HousekeeperService {

    @Autowired
    HousekeeperRepository housekeeperRepository;

    @Override
    @Transactional
    public Housekeeper getHousekeeper(int housekeeperId) {
        return housekeeperRepository.findById(housekeeperId).orElse(null);
    }

    @Override
    public List<Housekeeper> getAllHousekeepers() {
        return housekeeperRepository.findAll();
    }

    @Override
    @Transactional
    public void addAndSaveHousekeeper(Housekeeper housekeeper) {
        housekeeperRepository.save(housekeeper);
    }

    @Override
    @Transactional
    public void deleteHousekeeper(int housekeeperId) {
        housekeeperRepository.deleteById(housekeeperId);
    }
}

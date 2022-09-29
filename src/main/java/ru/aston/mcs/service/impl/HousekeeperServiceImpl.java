package ru.aston.mcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dao.HousekeeperRepository;
import ru.aston.mcs.entity.Housekeeper;
import ru.aston.mcs.service.HousekeeperService;

import java.util.List;
import java.util.Optional;

@Service
public class HousekeeperServiceImpl implements HousekeeperService {

    @Autowired
    HousekeeperRepository housekeeperRepository;

    @Override
    @Transactional
    public List<Housekeeper> getAllHousekeepers() {
        return housekeeperRepository.findAll();
    }

    @Override
    @Transactional
    public void saveHousekeeper(Housekeeper housekeeper) {
        housekeeperRepository.save(housekeeper);
    }

    @Override
    @Transactional
    public void deleteHousekeeper(int housekeeperId) {
        housekeeperRepository.deleteById(housekeeperId);
    }

    @Override
    @Transactional
    public Housekeeper getHousekeeper(int housekeeperId) {
        Housekeeper housekeeper = null;
        Optional<Housekeeper> housekeeperOptional = housekeeperRepository.findById(housekeeperId);

        if (housekeeperOptional.isPresent()){
            housekeeper = housekeeperOptional.get();
        }
        return housekeeper;
    }
}

package ru.aston.mcs.service;

import ru.aston.mcs.dto.HousekeeperDTO;
import ru.aston.mcs.entity.Housekeeper;

import java.util.List;

public interface HousekeeperService {

    void addAndSaveHousekeeper(HousekeeperDTO housekeeperDTO);

    void deleteHousekeeper(int housekeeperId);

    HousekeeperDTO getHousekeeper(int housekeeperId);
}

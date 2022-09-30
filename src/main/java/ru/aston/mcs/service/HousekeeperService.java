package ru.aston.mcs.service;

import ru.aston.mcs.entity.Housekeeper;

import java.util.List;

public interface HousekeeperService {
    List<Housekeeper> getAllHousekeepers();

    void addAndSaveHousekeeper(Housekeeper housekeeper);

    void deleteHousekeeper(int housekeeperId);

    Housekeeper getHousekeeper(int housekeeperId);
}

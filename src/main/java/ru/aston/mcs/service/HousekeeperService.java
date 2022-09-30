package ru.aston.mcs.service;


public interface HousekeeperService {
    List<Housekeeper> getAllHousekeepers();

    void addAndSaveHousekeeper(Housekeeper housekeeper);

    void deleteHousekeeper(Long housekeeperId);

    HousekeeperDTO getHousekeeper(Long housekeeperId);
}

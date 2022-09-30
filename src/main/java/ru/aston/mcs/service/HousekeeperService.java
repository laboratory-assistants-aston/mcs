package ru.aston.mcs.service;

import ru.aston.mcs.dto.HousekeeperDTO;

public interface HousekeeperService {

    void addAndSaveHousekeeper(HousekeeperDTO housekeeperDTO);

    void deleteHousekeeper(Long housekeeperId);

    HousekeeperDTO getHousekeeper(Long housekeeperId);
}

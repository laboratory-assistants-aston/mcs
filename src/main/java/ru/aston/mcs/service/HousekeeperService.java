package ru.aston.mcs.service;


import ru.aston.mcs.dto.HousekeeperDTO;

import java.util.List;

public interface HousekeeperService {
    List<HousekeeperDTO> getAllHousekeepers();

    void addAndSaveHousekeeper(HousekeeperDTO housekeeperDTO);

    void deleteHousekeeper(Long housekeeperId);

    HousekeeperDTO getHousekeeper(Long housekeeperId);
}

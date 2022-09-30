package ru.aston.mcs.service;


import ru.aston.mcs.dto.ManagerDTO;

import java.util.List;

public interface ManagerService {

    List<ManagerDTO> getAllManagers();

    ManagerDTO getManager(Long managerId);

    void addAndSaveManager(ManagerDTO manager);

    void deleteManager(Long managerId);


}

package ru.aston.mcs.service;

import ru.aston.mcs.dto.ManagerDTO;

public interface ManagerService {

    void saveManager(ManagerDTO managerDTO);

    void deleteManager(Long managerId);

    ManagerDTO getManager(Long managerId);
}

package ru.aston.mcs.service;

import ru.aston.mcs.dto.ManagerDTO;
import ru.aston.mcs.entity.Manager;

import java.util.List;

public interface ManagerService {

    void saveManager(ManagerDTO managerDTO);

    void deleteManager(int managerId);

    ManagerDTO getManager(int managerId);
}

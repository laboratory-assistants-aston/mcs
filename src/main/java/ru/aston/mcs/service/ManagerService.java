package ru.aston.mcs.service;

import ru.aston.mcs.entity.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> getAllManagers();

    void saveManager(Manager manager);

    void deleteManager(int managerId);

    Manager getManager(int managerId);
}

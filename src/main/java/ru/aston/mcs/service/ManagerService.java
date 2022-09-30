package ru.aston.mcs.service;

import ru.aston.mcs.entity.Manager;

public interface ManagerService {

    void saveManager(Manager manager);

    void deleteManager(int managerId);

    Manager getManager(int managerId);
}

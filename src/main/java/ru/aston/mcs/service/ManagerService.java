package ru.aston.mcs.service;



public interface ManagerService {

    void saveManager(Manager manager);

    void deleteManager(Long managerId);

    ManagerDTO getManager(Long managerId);
}

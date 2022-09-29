package ru.aston.mcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dao.ManagerRepository;
import ru.aston.mcs.entity.Manager;
import ru.aston.mcs.service.ManagerService;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerRepository managerRepository;

    @Override
    @Transactional
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    @Transactional
    public void saveManager(Manager manager) {
        managerRepository.save(manager);
    }

    @Override
    @Transactional
    public void deleteManager(int managerId) {
        managerRepository.deleteById(managerId);
    }

    @Override
    @Transactional
    public Manager getManager(int managerId) {
        Manager manager = null;
        Optional<Manager> managerOptional = managerRepository.findById(managerId);

        if (managerOptional.isPresent()){
            manager = managerOptional.get();
        }
        return manager;
    }
}

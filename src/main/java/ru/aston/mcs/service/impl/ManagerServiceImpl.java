package ru.aston.mcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.ManagerDTO;
import ru.aston.mcs.mapper.ManagerMapper;
import ru.aston.mcs.repository.ManagerRepository;
import ru.aston.mcs.service.ManagerService;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerRepository managerRepository;

    @Override
    @Transactional
    public void saveManager(Manager manager) {
        managerRepository.save(manager);
    }

    @Override
    public void deleteManager(Long managerId) {
        managerRepository.deleteById(managerId);
    }

    @Override
/*<<<<<<< feature/LA-role_fix
    @Transactional
    public Manager getManager(int managerId) {
        return managerRepository.findById(managerId).orElse(null);
=======*/
    public ManagerDTO getManager(Long managerId) {
        return managerMapper.managerInManagerDTO(managerRepository.findById(managerId).orElseThrow(RuntimeException::new));
    }
}

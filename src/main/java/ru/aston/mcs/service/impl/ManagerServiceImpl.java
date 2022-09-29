package ru.aston.mcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dao.ManagerRepository;
import ru.aston.mcs.dto.ManagerDTO;
import ru.aston.mcs.entity.Manager;
import ru.aston.mcs.mapper.ManagerMapper;
import ru.aston.mcs.service.ManagerService;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public void saveManager(ManagerDTO managerDTO) {
        managerRepository.save(managerMapper.managerDtoInManager(managerDTO));
    }

    @Override
    public void deleteManager(int managerId) {
        managerRepository.deleteById(managerId);
    }

    @Override
    public ManagerDTO getManager(int managerId) {
        return managerMapper.managerInManagerDTO(managerRepository.findById(managerId).orElseThrow(RuntimeException::new));
    }
}

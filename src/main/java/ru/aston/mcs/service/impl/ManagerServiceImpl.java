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

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public void saveManager(ManagerDTO managerDTO) {
        managerRepository.save(managerMapper.managerDtoInManager(managerDTO));
    }

    @Override
    public void deleteManager(Long managerId) {
        managerRepository.deleteById(managerId);
    }

    @Override
    public ManagerDTO getManager(Long managerId) {
        return managerMapper.managerInManagerDTO(managerRepository.findById(managerId).orElseThrow(RuntimeException::new));
    }
}

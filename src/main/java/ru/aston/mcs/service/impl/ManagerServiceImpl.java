package ru.aston.mcs.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.ManagerDTO;
import ru.aston.mcs.mapper.ManagerMapper;
import ru.aston.mcs.repository.ManagerRepository;
import ru.aston.mcs.service.ManagerService;

import java.util.List;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {


    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;

    public ManagerServiceImpl(ManagerRepository managerRepository, ManagerMapper managerMapper) {
        this.managerRepository = managerRepository;
        this.managerMapper = managerMapper;
    }


    @Override
    public List<ManagerDTO> getAllManagers() {
        return managerMapper.toDTOList(managerRepository.findAll());
    }

    @Override
    public ManagerDTO getManager(Long managerId) {
        return managerMapper.toDTO(
                managerRepository.findById(managerId)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public void addAndSaveManager(ManagerDTO managerDTO) {
        managerRepository.save(managerMapper.toModel(managerDTO));
    }

    @Override
    public void deleteManager(Long managerId) {
        managerRepository.deleteById(managerId);
    }

}

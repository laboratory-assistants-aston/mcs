package ru.aston.mcs.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.RolesDTO;
import ru.aston.mcs.mapper.RolesMapper;
import ru.aston.mcs.repository.RolesRepository;
import ru.aston.mcs.service.RolesService;

import java.util.List;

@Service
@Transactional
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;

    private final RolesMapper rolesMapper;

    public RolesServiceImpl(RolesRepository rolesRepository, RolesMapper rolesMapper) {
        this.rolesRepository = rolesRepository;
        this.rolesMapper = rolesMapper;
    }

    @Override
    public List<RolesDTO> getAllRoles() {
        return rolesMapper.toDTOList(rolesRepository.findAll());
    }

    @Override
    public RolesDTO getRole(Long roleId) {
        return rolesMapper.toDTO(
                rolesRepository.findById(roleId)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public void addAndSaveRole(RolesDTO rolesDTO) {
        rolesRepository.save(rolesMapper.toModel(rolesDTO));
    }

    @Override
    public void deleteRole(Long roleId) {
        rolesRepository.deleteById(roleId);
    }
}

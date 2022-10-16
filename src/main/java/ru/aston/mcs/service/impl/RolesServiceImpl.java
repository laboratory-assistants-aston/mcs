package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.RolesDTO;
import ru.aston.mcs.entity.Role;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.RolesMapper;
import ru.aston.mcs.repository.RolesRepository;
import ru.aston.mcs.service.RolesService;

import javax.persistence.EntityNotFoundException;
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
    public RolesDTO createRole(RolesDTO rolesDTO) {
        return rolesMapper.toDTO(
                rolesRepository.save(
                        rolesMapper.toModel(rolesDTO)));
    }

    @Override
    public RolesDTO updateRole(Long id, RolesDTO rolesDTO) {
        if (rolesDTO == null || id == null) {
            throw new InvalidRequestException();
        }

        Role rolesFromDb = rolesRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        rolesFromDb.setRoleName(rolesDTO.getRoleName());
        //rolesFromDb.setUsers(rolesDTO.getUsers());

        Role role = rolesRepository.save(rolesFromDb);
        RolesDTO rolesDTOResult = rolesMapper.toDTO(role);

        return rolesDTOResult;
    }

    @Override
    public void deleteRole(Long roleId) {
        rolesRepository.deleteById(roleId);
    }
}

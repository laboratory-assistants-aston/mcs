package ru.aston.mcs.service;

import ru.aston.mcs.dto.RolesDTO;

import java.util.List;

public interface RolesService {
    List<RolesDTO> getAllRoles();

    RolesDTO getRole(Long roleId);

    RolesDTO createRole(RolesDTO rolesDTO);

    RolesDTO updateRole(Long id, RolesDTO rolesDTO);

    void deleteRole(Long roleId);
}

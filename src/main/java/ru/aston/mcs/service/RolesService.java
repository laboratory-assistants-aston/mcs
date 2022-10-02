package ru.aston.mcs.service;

import ru.aston.mcs.dto.RolesDTO;

import java.util.List;

public interface RolesService {
    List<RolesDTO> getAllRoles();

    RolesDTO getRole(Long roleId);

    void addAndSaveRole(RolesDTO rolesDTO);

    void deleteRole(Long roleId);
}

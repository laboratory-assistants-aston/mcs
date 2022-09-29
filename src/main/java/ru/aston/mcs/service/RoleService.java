package ru.aston.mcs.service;

import ru.aston.mcs.dto.RoleDTO;
import ru.aston.mcs.entity.Role;

import java.util.List;

public interface RoleService {

    void saveRole(RoleDTO roleDTO);

    void deleteRole(int roleId);

    RoleDTO getRole(int roleId);
}

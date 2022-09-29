package ru.aston.mcs.service;

import ru.aston.mcs.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    void saveRole(Role role);

    void deleteRole(int roleId);

    Role getRole(int roleId);
}

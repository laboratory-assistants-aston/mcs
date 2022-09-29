package ru.aston.mcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dao.RoleRepository;
import ru.aston.mcs.entity.Role;
import ru.aston.mcs.service.RoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public void deleteRole(int roleId) {
        roleRepository.deleteById(roleId);
    }

    @Override
    @Transactional
    public Role getRole(int roleId) {
        Role role = null;
        Optional<Role> roleOptional = roleRepository.findById(roleId);

        if (roleOptional.isPresent()){
            role = roleOptional.get();
        }
        return role;
    }
}

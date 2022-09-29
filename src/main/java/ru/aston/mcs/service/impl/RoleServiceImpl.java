package ru.aston.mcs.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.mcs.repository.RoleRepository;
import ru.aston.mcs.dto.RoleDTO;
import ru.aston.mcs.mapper.RoleMapper;
import ru.aston.mcs.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public void saveRole(RoleDTO roleDTO) {
        roleRepository.save(roleMapper.roleDtoInRole(roleDTO));
    }

    @Override
    public void deleteRole(int roleId) {
        roleRepository.deleteById(roleId);
    }

    @Override
    public RoleDTO getRole(int roleId) {
        return roleMapper.roleInRoleDTO(roleRepository.findById(roleId).orElseThrow(RuntimeException::new));
    }
}

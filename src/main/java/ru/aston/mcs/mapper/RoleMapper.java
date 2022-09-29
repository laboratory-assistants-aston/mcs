package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.RoleDTO;
import ru.aston.mcs.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role roleDtoInRole(RoleDTO roleDTO);

    RoleDTO roleInRoleDTO(Role role);
}

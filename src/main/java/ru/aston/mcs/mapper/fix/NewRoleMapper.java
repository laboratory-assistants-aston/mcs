package ru.aston.mcs.mapper.fix;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.request.RoleRequest;
import ru.aston.mcs.dto.response.RoleResponse;
import ru.aston.mcs.entity.Role;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewRoleMapper {

    Role toEntity(RoleRequest roleRequest);

    RoleResponse toResponse(Role role);
    List<RoleResponse> toResponseList(List<Role> role);

}

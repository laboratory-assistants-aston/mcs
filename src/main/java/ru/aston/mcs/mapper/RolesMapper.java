package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.RolesDTO;
import ru.aston.mcs.entity.Role;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolesMapper {
    Role toModel(RolesDTO roleDto);

    RolesDTO toDTO(Role role);

    List<Role> toModelList(List<RolesDTO> rolesDtoList);

    List<RolesDTO> toDTOList(List<Role> roleList);
}

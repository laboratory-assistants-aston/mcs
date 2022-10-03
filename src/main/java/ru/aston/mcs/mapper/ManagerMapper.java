package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.ManagerDTO;
import ru.aston.mcs.entity.Manager;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
    Manager toModel(ManagerDTO managerDTO);

    ManagerDTO toDTO(Manager manager);

    List<Manager> toModelList(List<ManagerDTO> managerDTOList);

    List<ManagerDTO> toDTOList(List<Manager> managerList);
}

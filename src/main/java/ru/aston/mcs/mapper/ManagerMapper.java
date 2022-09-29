package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.ManagerDTO;
import ru.aston.mcs.entity.Manager;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
    Manager managerDtoInManager(ManagerDTO managerDTO);

    ManagerDTO managerInManagerDTO(Manager manager);
}

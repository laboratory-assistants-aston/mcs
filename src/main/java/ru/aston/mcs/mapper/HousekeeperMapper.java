package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.HousekeeperDTO;
import ru.aston.mcs.entity.Housekeeper;

@Mapper(componentModel = "spring")
public interface HousekeeperMapper {
    Housekeeper housekeeperDtoInHousekeeper(HousekeeperDTO housekeeperDTO);

    HousekeeperDTO housekeeperInHousekeeperDto(Housekeeper housekeeper);
}

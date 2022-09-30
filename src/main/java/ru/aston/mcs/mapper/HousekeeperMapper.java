package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.HousekeeperDTO;
import ru.aston.mcs.dto.ResourcesDTO;
import ru.aston.mcs.entity.Housekeeper;
import ru.aston.mcs.entity.Resource;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HousekeeperMapper {
    Housekeeper housekeeperDtoInHousekeeper(HousekeeperDTO housekeeperDTO);

    HousekeeperDTO housekeeperInHousekeeperDto(Housekeeper housekeeper);

    List<Housekeeper> listHousekeeperDtoInHousekeeperList(List<HousekeeperDTO> housekeeperDtoList);

    List<HousekeeperDTO> listHousekeeperInHousekeeperDtoList(List<Housekeeper> housekeeperDtoList);
}

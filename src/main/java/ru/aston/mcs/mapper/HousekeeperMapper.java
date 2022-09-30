package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.HousekeeperDTO;
import ru.aston.mcs.entity.Housekeeper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HousekeeperMapper {
    Housekeeper toModel(HousekeeperDTO housekeeperDTO);

    HousekeeperDTO toDTO(Housekeeper housekeeper);

    List<Housekeeper> toModelList(List<HousekeeperDTO> housekeeperDtoList);

    List<HousekeeperDTO> toDTOList(List<Housekeeper> housekeeperDtoList);
}

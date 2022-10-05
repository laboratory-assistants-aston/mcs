package ru.aston.mcs.mapper;


import org.mapstruct.Mapper;
import ru.aston.mcs.dto.ResidentDTO;
import ru.aston.mcs.entity.Resident;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResidentMapper {

    Resident toModel(ResidentDTO residentDTO);

    ResidentDTO toDTO(Resident resident);

    List<Resident> toModelList(List<ResidentDTO> residentDTO);

    List<ResidentDTO> toDTOList(List<Resident> residentList);
}
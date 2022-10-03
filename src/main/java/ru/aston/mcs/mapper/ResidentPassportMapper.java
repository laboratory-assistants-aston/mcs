package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.ResidentPassportDTO;
import ru.aston.mcs.entity.ResidentPassport;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResidentPassportMapper {
    ResidentPassport toModel(ResidentPassportDTO residentPassportDTO);

    ResidentPassportDTO toDTO(ResidentPassport residentPassport);

    List<ResidentPassport> toModelList(List<ResidentPassportDTO> residentPassportDTOList);

    List<ResidentPassportDTO> toDTOList(List<ResidentPassport> residentPassportList);
}

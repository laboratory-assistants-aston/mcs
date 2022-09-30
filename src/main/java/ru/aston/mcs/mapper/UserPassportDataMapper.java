package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.UserPassportDataDTO;
import ru.aston.mcs.entity.UserPassportData;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserPassportDataMapper {
    UserPassportData toModel(UserPassportDataDTO userPassportDataDTO);

    UserPassportDataDTO toDTO(UserPassportData userPassportData);

    List<UserPassportData> toModelList(List<UserPassportDataDTO> userPassportDataDTO);

    List<UserPassportDataDTO> toDTOList(List<UserPassportData> userPassportData);
}

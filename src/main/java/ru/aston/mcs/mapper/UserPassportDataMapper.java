package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.UserPassportDataDTO;
import ru.aston.mcs.entity.UserPassportData;

@Mapper(componentModel = "spring")
public interface UserPassportDataMapper {
    UserPassportData userPassportDataDtoInUserPassportData(UserPassportDataDTO userPassportDataDTO);

    UserPassportDataDTO userPassportDataInUserPassportDataDTO(UserPassportData userPassportData);
}

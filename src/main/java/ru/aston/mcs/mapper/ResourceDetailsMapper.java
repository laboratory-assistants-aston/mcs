package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.ResourceDetailsDTO;
import ru.aston.mcs.entity.ResourceDetails;

@Mapper(
        componentModel = "spring"
)
public interface ResourceDetailsMapper {
    ResourceDetailsDTO toDTO(ResourceDetails model);

    ResourceDetails toModel(ResourceDetailsDTO dto);
}

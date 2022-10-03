package ru.aston.mcs.mapper;


import org.mapstruct.Mapper;
import ru.aston.mcs.dto.ResourceTypeDTO;
import ru.aston.mcs.entity.ResourceType;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface ResourceTypeMapper {
    ResourceTypeDTO toDTO(ResourceType resourceType);

    ResourceType toModel(ResourceTypeDTO resourceTypeDTO);

    List<ResourceType> toModelList(List<ResourceTypeDTO> resourceTypeDTOList);

    List<ResourceTypeDTO> toDTOList(List<ResourceType> resourceTypeList);
}

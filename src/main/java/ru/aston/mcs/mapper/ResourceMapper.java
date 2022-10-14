package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.ResourceDTO;
import ru.aston.mcs.entity.Resource;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResourceMapper {

    ResourceDTO toDTO(Resource resource);

    Resource toModel(ResourceDTO resourceDTO);

    List<Resource> toModelList(List<ResourceDTO> resourceDTOList);

    List<ResourceDTO> toDTOList(List<Resource> resourceList);
}

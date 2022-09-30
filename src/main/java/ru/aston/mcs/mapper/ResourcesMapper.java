package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.ResourcesDTO;
import ru.aston.mcs.entity.Resource;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResourcesMapper {
    Resource resourceDtoInResource(ResourcesDTO wordDto);

    ResourcesDTO resourceInResourceDto(Resource word);

    List<Resource> listResourceDtoInResourceList(List<ResourcesDTO> wordDtoList);

    List<ResourcesDTO> listResourceInResourceDtoList(List<Resource> wordDtoList);
}

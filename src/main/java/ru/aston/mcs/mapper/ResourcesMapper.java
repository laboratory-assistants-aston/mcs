package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.ResourcesDto;
import ru.aston.mcs.entity.Resource;

import java.util.List;

@Mapper
public interface ResourcesMapper {
    Resource resourceDtoInResource(ResourcesDto wordDto);

    ResourcesDto ResourceInResourceDto(Resource word);

    List<Resource> listResourceDtoInResourceList(List<ResourcesDto> wordDtoList);

    List<ResourcesDto> listResourceInResourceDtoList(List<Resource> wordDtoList);
}

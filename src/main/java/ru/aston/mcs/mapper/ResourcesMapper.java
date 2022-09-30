package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.ResourcesDTO;
import ru.aston.mcs.entity.Resource;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResourcesMapper {
    Resource toModel(ResourcesDTO wordDto);

    ResourcesDTO toDTO(Resource word);

    List<Resource> toModelList(List<ResourcesDTO> wordDtoList);

    List<ResourcesDTO> toDTOList(List<Resource> wordDtoList);
}

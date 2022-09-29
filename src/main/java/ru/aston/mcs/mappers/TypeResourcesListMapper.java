package ru.aston.mcs.mappers;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.TypeResourcesDTO;
import ru.aston.mcs.entity.TypeResources;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {TypeResourcesListMapper.class, TypeResourcesMapper.class}
)
public interface TypeResourcesListMapper {
    List<TypeResources> toModelList(List<TypeResourcesDTO> resourceDetailsDTOList);

    List<TypeResourcesDTO> toDTOList(List<TypeResources> modelList);
}

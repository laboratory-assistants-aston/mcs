package ru.aston.mcs.mapper;


import org.mapstruct.Mapper;
import ru.aston.mcs.dto.TypeResourcesDTO;
import ru.aston.mcs.entity.TypeResources;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface TypeResourcesMapper {
    TypeResourcesDTO toDTO(TypeResources model);

    TypeResources toModel(TypeResourcesDTO dto);

    List<TypeResources> toModelList(List<TypeResourcesDTO> resourceDetailsDTOList);

    List<TypeResourcesDTO> toDTOList(List<TypeResources> modelList);
}

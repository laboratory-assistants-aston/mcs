package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.ResourceDetailsDTO;
import ru.aston.mcs.entity.ResourceDetails;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface ResourceDetailsMapper {
    ResourceDetailsDTO toDTO(ResourceDetails model);

    ResourceDetails toModel(ResourceDetailsDTO dto);

    List<ResourceDetails> toModelList(List<ResourceDetailsDTO> resourceDetailsDTOList);

    List<ResourceDetailsDTO> toDTOList(List<ResourceDetails> modelList);
}

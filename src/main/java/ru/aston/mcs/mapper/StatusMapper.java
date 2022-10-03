package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.StatusDTO;
import ru.aston.mcs.entity.Status;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    Status toModel(StatusDTO statusDTO);

    StatusDTO toDTO(Status status);

    List<Status> toModelList(List<StatusDTO> statusDTOList);

    List<StatusDTO> toDTOList(List<Status> statusList);
}

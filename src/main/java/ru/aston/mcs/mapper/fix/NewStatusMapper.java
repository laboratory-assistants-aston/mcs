package ru.aston.mcs.mapper.fix;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.request.StatusRequest;
import ru.aston.mcs.dto.response.StatusResponse;
import ru.aston.mcs.entity.Status;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewStatusMapper {

    Status toEntity(StatusRequest statusRequest);

    StatusResponse toResponse(Status status);

    List<StatusResponse> toResponseList(List<Status> statusList);
}

package ru.aston.mcs.mapper.fix;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.request.ResourceRequest;
import ru.aston.mcs.dto.response.ResourceResponse;
import ru.aston.mcs.entity.Resource;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewResourceMapper {

    Resource toEntity(ResourceRequest resourceRequest);

    ResourceResponse toResponse(Resource resource);

    List<ResourceResponse> toResponseList(List<Resource> resourceList);

}

package ru.aston.mcs.mapper.fix;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.request.ResourceTypeRequest;
import ru.aston.mcs.dto.response.ResourceTypeResponse;
import ru.aston.mcs.entity.ResourceType;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewResourceTypeMapper {

    ResourceType toEntity(ResourceTypeRequest resourceTypeRequest);
    ResourceTypeResponse toResponse(ResourceType resourceType);
    List<ResourceTypeResponse> toResponseList(List<ResourceType> resourceType);

}

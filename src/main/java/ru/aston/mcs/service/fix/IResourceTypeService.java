package ru.aston.mcs.service.fix;

import ru.aston.mcs.dto.request.ResourceTypeRequest;
import ru.aston.mcs.dto.response.ResourceTypeResponse;

import java.util.List;

public interface IResourceTypeService {

    List<ResourceTypeResponse> getAll();

    ResourceTypeResponse get(Long id);

    ResourceTypeResponse create(ResourceTypeRequest resourceTypeRequest);

    ResourceTypeResponse update(Long id, ResourceTypeRequest resourceTypeRequest);

    void delete(Long id);
}

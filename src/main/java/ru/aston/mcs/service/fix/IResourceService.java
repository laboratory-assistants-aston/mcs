package ru.aston.mcs.service.fix;

import ru.aston.mcs.dto.request.ResourceRequest;
import ru.aston.mcs.dto.response.ResourceResponse;

import java.util.List;

public interface IResourceService {

    List<ResourceResponse> getAll();

    ResourceResponse get(Long id);

    ResourceResponse create(ResourceRequest resourceRequest);

    ResourceResponse update(Long id, ResourceRequest resourceRequest);

    void delete(Long id);
}

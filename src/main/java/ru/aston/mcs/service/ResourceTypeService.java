package ru.aston.mcs.service;

import ru.aston.mcs.dto.ResourceTypeDTO;

import java.util.List;

public interface ResourceTypeService {

    List<ResourceTypeDTO> getAllResourceTypes();

    void addAndSaveResourceType(ResourceTypeDTO resourceTypeDTO);

    void deleteResourceType(Long nameId);

    ResourceTypeDTO getResourceType(Long nameId);
}
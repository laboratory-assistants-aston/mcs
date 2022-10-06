package ru.aston.mcs.service;

import ru.aston.mcs.dto.ResourceTypeDTO;
import ru.aston.mcs.dto.StatusDTO;

import java.util.List;

public interface ResourceTypeService {

    List<ResourceTypeDTO> getAllResourceTypes();

    ResourceTypeDTO getResourceType(Long nameId);

    void saveResourceType(ResourceTypeDTO resourceTypeDTO);

    ResourceTypeDTO updateResourceType(ResourceTypeDTO resourceTypeDTO);

    void deleteResourceType(Long nameId);

}
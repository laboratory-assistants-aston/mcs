package ru.aston.mcs.service;

import ru.aston.mcs.dto.ResourceDTO;

import java.util.List;

public interface ResourceService {
    List<ResourceDTO> getAllResource();

    void deleteResource(Long id);

    ResourceDTO getResource(Long id);

    ResourceDTO updateResource(Long id, ResourceDTO resourcesDto);

    ResourceDTO create(ResourceDTO resourcesDto);
}

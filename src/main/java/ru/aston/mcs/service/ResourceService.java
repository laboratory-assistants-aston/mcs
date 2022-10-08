package ru.aston.mcs.service;

import ru.aston.mcs.dto.ResourceDTO;

import java.util.List;

public interface ResourceService {
    List<ResourceDTO> getAllResource();

    void addAndSaveResource(ResourceDTO resource);

    void deleteResource(Long id);

    ResourceDTO getResource(Long id);
}

package ru.aston.mcs.service;

import ru.aston.mcs.dto.ResourceDTO;

import java.util.List;

public interface ResourceServices {

    List<ResourceDTO> getAllResources();

    ResourceDTO getResource(Long id);

    void addAndSaveResource(ResourceDTO resourceDTO);

    void deleteResource(Long id);
}

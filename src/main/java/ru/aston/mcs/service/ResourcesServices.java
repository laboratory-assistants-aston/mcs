package ru.aston.mcs.service;

import ru.aston.mcs.dto.ResourcesDTO;

import java.util.List;

public interface ResourcesServices {

    List<ResourcesDTO> getAllResources();

    ResourcesDTO getResource(Long id);

    void addAndSaveResource(ResourcesDTO resourcesDTO);

    void deleteResource(Long id);
}

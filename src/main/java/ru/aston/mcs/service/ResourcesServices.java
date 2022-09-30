package ru.aston.mcs.service;

import ru.aston.mcs.dto.ResourcesDTO;

public interface ResourcesServices {
    ResourcesDTO getResource(Long id);

    void addAndSaveResource(ResourcesDTO userDto);

    void deleteResource(Long id);
}

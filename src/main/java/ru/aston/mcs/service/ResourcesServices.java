package ru.aston.mcs.service;

import ru.aston.mcs.dto.ResourcesDto;

public interface ResourcesServices {
    ResourcesDto getResource(Long id);

    void addAndSaveResource(ResourcesDto userDto);

    void deleteResource(Long id);
}

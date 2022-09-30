package ru.aston.mcs.service;

import ru.aston.mcs.dto.ResourcesDTO;
import ru.aston.mcs.entity.Resource;

public interface ResourcesServices {
/*    ResourcesDTO getResource(Long id);

    void addAndSaveResource(ResourcesDTO userDto);

    void deleteResource(Long id);*/
    Resource getResource(Long id);

    void addAndSaveResource(Resource user);
    void deleteResource(Long id);
}

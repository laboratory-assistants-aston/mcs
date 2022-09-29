package ru.aston.mcs.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.ResourcesDto;
import ru.aston.mcs.mapper.ResourcesMapper;
import ru.aston.mcs.repositories.ResourcesRepository;
import ru.aston.mcs.services.ResourcesServices;

@Service
public class ResourcesServicesImpl implements ResourcesServices {

    @Autowired
    ResourcesRepository resourcesRepository;
    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public ResourcesDto getResource(Long id) {
        return resourcesMapper.ResourceInResourceDto(resourcesRepository.findById(id).orElseThrow(RuntimeException::new));
    }


    @Override
    public void addAndSaveResource(ResourcesDto resourcesDto) {
        resourcesRepository.save(resourcesMapper.resourceDtoInResource(resourcesDto));
    }

    @Override
    public void deleteResource(Long id) {
        resourcesRepository.deleteById(id);
    }
}

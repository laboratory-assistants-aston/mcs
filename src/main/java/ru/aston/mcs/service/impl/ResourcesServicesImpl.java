package ru.aston.mcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.ResourcesDTO;
import ru.aston.mcs.mapper.ResourcesMapper;
import ru.aston.mcs.repository.ResourcesRepository;
import ru.aston.mcs.service.ResourcesServices;

@Service
@Transactional
public class ResourcesServicesImpl implements ResourcesServices {

    @Autowired
    ResourcesRepository resourcesRepository;
    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public ResourcesDTO getResource(Long id) {
        return resourcesMapper.ResourceInResourceDto(resourcesRepository.findById(id).orElseThrow(RuntimeException::new));
    }


    @Override
    public void addAndSaveResource(ResourcesDTO resourcesDto) {
        resourcesRepository.save(resourcesMapper.resourceDtoInResource(resourcesDto));
    }

    @Override
    public void deleteResource(Long id) {
        resourcesRepository.deleteById(id);
    }
}

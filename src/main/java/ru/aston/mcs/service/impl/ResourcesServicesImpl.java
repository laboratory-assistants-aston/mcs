package ru.aston.mcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.mcs.mapper.ResourcesMapper;
import ru.aston.mcs.repository.ResourcesRepository;
import ru.aston.mcs.service.ResourcesServices;

@Service
/*
public class ResourcesServicesImpl implements ResourcesServices {
    @Autowired
    ResourcesRepository resourcesRepository;

    @Override
    public Resource getResource(Long id) {
        return resourcesRepository.findById(id).orElse(null);
    }

    @Override
    public void addAndSaveResource(Resource user) {
        resourcesRepository.save(user);
    }

    @Override
    public void deleteResource(Long id) {
        resourcesRepository.deleteById(id);
    }


*/

@Transactional
public class ResourcesServicesImpl implements ResourcesServices {

    @Autowired
    ResourcesRepository resourcesRepository;
    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public ResourcesDTO getResource(Long id) {
/* большой буква<<<<<<< feature/LA-role_fix
        return resourcesMapper.resourceInResourceDto(resourcesRepository.findById(id).orElseThrow(RuntimeException::new));
 */
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

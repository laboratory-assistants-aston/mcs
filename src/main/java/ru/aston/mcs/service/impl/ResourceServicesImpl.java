package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.ResourceDTO;
import ru.aston.mcs.mapper.ResourceMapper;
import ru.aston.mcs.repository.ResourceRepository;
import ru.aston.mcs.service.ResourceServices;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResourceServicesImpl implements ResourceServices {

    private final ResourceRepository resourceRepository;

    private final ResourceMapper resourceMapper;

    public ResourceServicesImpl(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public List<ResourceDTO> getAllResources() {
        return resourceMapper.toDTOList(resourceRepository.findAll());
    }

    @Override
    public ResourceDTO getResource(Long id) {

        return resourceMapper.toDTO(
                resourceRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }


    @Override
    public void addAndSaveResource(ResourceDTO resourceDto) {
        resourceRepository.save(
                resourceMapper.toModel(resourceDto));
    }

    @Override
    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }

}

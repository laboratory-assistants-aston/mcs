package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.ResourcesDTO;
import ru.aston.mcs.mapper.ResourcesMapper;
import ru.aston.mcs.repository.ResourcesRepository;
import ru.aston.mcs.service.ResourcesServices;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResourcesServicesImpl implements ResourcesServices {

    private final ResourcesRepository resourcesRepository;

    private final ResourcesMapper resourcesMapper;

    public ResourcesServicesImpl(ResourcesRepository resourcesRepository, ResourcesMapper resourcesMapper) {
        this.resourcesRepository = resourcesRepository;
        this.resourcesMapper = resourcesMapper;
    }

    @Override
    public List<ResourcesDTO> getAllResources() {
        return resourcesMapper.toDTOList(resourcesRepository.findAll());
    }

    @Override
    public ResourcesDTO getResource(Long id) {

        return resourcesMapper.toDTO(
                resourcesRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }


    @Override
    public void addAndSaveResource(ResourcesDTO resourcesDto) {
        resourcesRepository.save(
                resourcesMapper.toModel(resourcesDto));
    }

    @Override
    public void deleteResource(Long id) {
        resourcesRepository.deleteById(id);
    }

}

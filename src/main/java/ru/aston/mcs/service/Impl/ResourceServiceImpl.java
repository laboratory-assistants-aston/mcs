package ru.aston.mcs.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.ResourceDTO;
import ru.aston.mcs.mapper.ResourceMapper;
import ru.aston.mcs.repository.ResourceRepository;
import ru.aston.mcs.service.ResourceService;

import java.util.List;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    public ResourceServiceImpl(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }


    @Override
    public List<ResourceDTO> getAllResource() {
        return resourceMapper.toDTOList(resourceRepository.findAll());
    }

    @Override
    public void addAndSaveResource(ResourceDTO resourceDTO) {
        resourceRepository.save(resourceMapper.toModel(resourceDTO));
    }

    @Override
    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }

    @Override
    public ResourceDTO getResource(Long id) {
        return resourceMapper.toDTO(
                resourceRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }
}

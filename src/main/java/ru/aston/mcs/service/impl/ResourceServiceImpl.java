package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.ResourceDTO;
import ru.aston.mcs.entity.Resource;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
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
    public ResourceDTO getResource(Long id) {
        return resourceMapper.toDTO(
                resourceRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public ResourceDTO create(ResourceDTO resourcesDto) {
        if (resourcesDto == null) {
            throw new InvalidRequestException();
        }
        return resourceMapper.toDTO(
                resourceRepository.save(
                        resourceMapper.toModel(resourcesDto)));
    }

    @Override
    public ResourceDTO updateResource(Long id, ResourceDTO resourcesDto) {
        if (resourcesDto == null || id == null) {
            throw new InvalidRequestException();
        }
        Resource bookingResource = resourceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        bookingResource.setResourceId(resourcesDto.getId());
        return resourceMapper.toDTO(resourceRepository.save(bookingResource));
    }


    @Override
    public void deleteResource(Long id) {

         resourceRepository.deleteById(id);
    }

}

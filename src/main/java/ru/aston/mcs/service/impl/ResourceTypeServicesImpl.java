package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.ResourceTypeDTO;
import ru.aston.mcs.entity.ResourceType;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.ResourceTypeMapper;
import ru.aston.mcs.repository.ResourceTypeRepository;
import ru.aston.mcs.service.ResourceTypeService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResourceTypeServicesImpl implements ResourceTypeService {

    private final ResourceTypeRepository typeResourcesRepository;
    private final ResourceTypeMapper typeResourcesMapper;

    public ResourceTypeServicesImpl(ResourceTypeRepository typeResourcesRepository, ResourceTypeMapper typeResourcesMapper) {
        this.typeResourcesRepository = typeResourcesRepository;
        this.typeResourcesMapper = typeResourcesMapper;
    }

    @Override
    public List<ResourceTypeDTO> getAllResourceTypes() {
        return typeResourcesMapper.toDTOList(typeResourcesRepository.findAll());
    }

    @Override
    public ResourceTypeDTO getResourceType(Long nameId) {

        return typeResourcesMapper.toDTO(
                typeResourcesRepository.findById(nameId)
                        .orElseThrow(() -> new EntityNotFoundException(nameId)));
    }

    @Override
    public ResourceTypeDTO createResourceType(ResourceTypeDTO resourceTypeDTO) {

        if (resourceTypeDTO == null ) {
            throw new InvalidRequestException();
        }

        ResourceType resourceTypeFromDb = typeResourcesRepository.save(typeResourcesMapper.toModel(resourceTypeDTO));
        return typeResourcesMapper.toDTO(typeResourcesRepository.save(resourceTypeFromDb));
    }

    @Override
    public ResourceTypeDTO updateResourceType(ResourceTypeDTO resourceTypeDTO) {

        if (resourceTypeDTO == null || resourceTypeDTO.getNameId() == null) {
            throw new InvalidRequestException();
        }

        Long resourceTypeId = resourceTypeDTO.getNameId();
        ResourceType resourceTypeFromDb =  typeResourcesRepository.findById(resourceTypeId)
                .orElseThrow( () -> new EntityNotFoundException(resourceTypeId));

        resourceTypeFromDb.setName(resourceTypeDTO.getName());
        resourceTypeFromDb.setCost(resourceTypeDTO.getCost());

        return typeResourcesMapper.toDTO(typeResourcesRepository.save(resourceTypeFromDb));
    }

    @Override
    public void deleteResourceType(Long nameId) {

        if (typeResourcesRepository.findById(nameId).isEmpty()) {
            throw new EntityNotFoundException( nameId );
        }

        typeResourcesRepository.deleteById(nameId);
    }

}

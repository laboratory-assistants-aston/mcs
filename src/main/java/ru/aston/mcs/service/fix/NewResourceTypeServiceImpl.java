package ru.aston.mcs.service.fix;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.request.ResourceTypeRequest;
import ru.aston.mcs.dto.response.ResourceTypeResponse;
import ru.aston.mcs.entity.ResourceType;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.fix.NewResourceTypeMapper;
import ru.aston.mcs.repository.ResourceTypeRepository;

import java.util.List;

@Service
@Transactional
public class NewResourceTypeServiceImpl implements IResourceTypeService {


    private final ResourceTypeRepository resourceTypeRepository;
    private final NewResourceTypeMapper newResourceTypeMapper;

    public NewResourceTypeServiceImpl(ResourceTypeRepository resourceTypeRepository, NewResourceTypeMapper newResourceTypeMapper) {
        this.resourceTypeRepository = resourceTypeRepository;
        this.newResourceTypeMapper = newResourceTypeMapper;
    }


    @Override
    public List<ResourceTypeResponse> getAll() {
        return newResourceTypeMapper.toResponseList(resourceTypeRepository.findAll());
    }

    @Override
    public ResourceTypeResponse get(Long id) {
        return newResourceTypeMapper.toResponse(
                resourceTypeRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public ResourceTypeResponse create(ResourceTypeRequest resourceTypeRequest) {
        if (resourceTypeRequest == null) {
            throw new InvalidRequestException();
        }
        return newResourceTypeMapper.toResponse(
                resourceTypeRepository.save(
                        newResourceTypeMapper.toEntity(resourceTypeRequest)));
    }

    @Override
    public ResourceTypeResponse update(Long id, ResourceTypeRequest resourceTypeRequest) {
        if (resourceTypeRequest == null || id == null) {
            throw new InvalidRequestException();
        }
        ResourceType resourceTypeFromDb =
                resourceTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        resourceTypeFromDb.setResourceTypeName(resourceTypeRequest.getResourceTypeName());
        resourceTypeFromDb.setResourceTypeCost(resourceTypeRequest.getResourceTypeCost());

        return newResourceTypeMapper.toResponse(resourceTypeRepository.save(resourceTypeFromDb));
    }

    @Override
    public void delete(Long id) {
        resourceTypeRepository.deleteById(id);
    }
}

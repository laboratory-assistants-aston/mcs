package ru.aston.mcs.service.fix;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.request.ResourceRequest;
import ru.aston.mcs.dto.response.ResourceResponse;
import ru.aston.mcs.entity.Resource;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.fix.NewResourceMapper;
import ru.aston.mcs.repository.ResourceRepository;

import java.util.List;

@Service
@Transactional
public class NewResourceServiceImpl implements IResourceService{

    private final ResourceRepository resourceRepository;
    private final NewResourceMapper newResourceMapper;

    public NewResourceServiceImpl(ResourceRepository resourceRepository, NewResourceMapper newResourceMapper) {
        this.resourceRepository = resourceRepository;
        this.newResourceMapper = newResourceMapper;
    }

    @Override
    public List<ResourceResponse> getAll() {

        return  newResourceMapper.toResponseList(resourceRepository.findAll());
    }

    @Override
    public ResourceResponse get(Long id) {

        return newResourceMapper.toResponse(
                resourceRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public ResourceResponse create(ResourceRequest resourceRequest) {

        if (resourceRequest == null) {
            throw new InvalidRequestException();
        }
        return newResourceMapper.toResponse(
                resourceRepository.save(
                        newResourceMapper.toEntity(resourceRequest)));
    }

    @Override
    public ResourceResponse update(Long id, ResourceRequest resourceRequest) {
        if (resourceRequest == null || id == null) {
            throw new InvalidRequestException();
        }
        Resource bookingResource =
                resourceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        bookingResource.setResourceType(resourceRequest.getResourceType());
        bookingResource.setResourceIdentifier(resourceRequest.getResourceIdentifier());
        bookingResource.setStatus(resourceRequest.getStatus());

        return newResourceMapper.toResponse(resourceRepository.save(bookingResource));
    }

    @Override
    public void delete(Long id) {
        resourceRepository.deleteById(id);
    }
}

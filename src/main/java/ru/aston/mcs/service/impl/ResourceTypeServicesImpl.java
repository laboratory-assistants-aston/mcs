package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.ResourceTypeDTO;
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
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public void addAndSaveResourceType(ResourceTypeDTO resourceTypeDTO) {

        typeResourcesRepository.save(typeResourcesMapper.toModel(resourceTypeDTO));
    }

    @Override
    public void deleteResourceType(Long nameId) {
        typeResourcesRepository.deleteById(nameId);
    }

}

package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.ResourceDetailsDTO;
import ru.aston.mcs.mapper.ResourceDetailsMapper;
import ru.aston.mcs.repository.ResourceDetailsRepository;
import ru.aston.mcs.service.ResourceDetailsService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResourceDetailsServiceImpl implements ResourceDetailsService {

    private final ResourceDetailsMapper resourceDetailsMapper;
    private final ResourceDetailsRepository resourceDetailsRepository;

    public ResourceDetailsServiceImpl(ResourceDetailsRepository resourceDetailsRepository, ResourceDetailsMapper resourceDetailsMapper) {
        this.resourceDetailsRepository = resourceDetailsRepository;
        this.resourceDetailsMapper = resourceDetailsMapper;
    }

    @Override
    public List<ResourceDetailsDTO> getAllResourceDetails() {
        return resourceDetailsMapper.toDTOList(resourceDetailsRepository.findAll());
    }

    @Override
    public ResourceDetailsDTO getResourceDetails(Long detailsId) {
        return resourceDetailsMapper.toDTO(
                resourceDetailsRepository.findById(detailsId)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public void addAndSaveResourceDetails(ResourceDetailsDTO resourceDetailsDTO) {
        resourceDetailsRepository.save(resourceDetailsMapper.toModel(resourceDetailsDTO));
    }

    @Override
    public void deleteResourceDetails(Long detailsId) {
        resourceDetailsRepository.deleteById(detailsId);
    }

}

package ru.aston.mcs.dao.impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.dao.ResourceDetailsService;
import ru.aston.mcs.entity.ResourceDetails;
import ru.aston.mcs.repository.ResourceDetailsRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceDetailsServiceImpl implements ResourceDetailsService {

    public final ResourceDetailsRepository resourceDetailsRepository;

    public ResourceDetailsServiceImpl(ResourceDetailsRepository resourceDetailsRepository) {
        this.resourceDetailsRepository = resourceDetailsRepository;
    }

    @Override
    @Transactional
    public List<ResourceDetails> getAllResourceDetails() {
        return resourceDetailsRepository.findAll();
    }

    @Override
    public void saveResourceDetails(ResourceDetails resourceDetails) {
        resourceDetailsRepository.save(resourceDetails);
    }

    @Override
    @Transactional
    public void deleteResourceDetails(int detailsId) {
        resourceDetailsRepository.deleteById(detailsId);
    }

    @Override
    @Transactional
    public ResourceDetails getResourceDetails(int detailsId) {
        ResourceDetails resourceDetails = null;
        Optional<ResourceDetails> resourceDetailsOptional = resourceDetailsRepository.findById(detailsId);

        if (resourceDetailsOptional.isPresent()){
            resourceDetails = resourceDetailsOptional.get();
        }
        return resourceDetails;
    }
}

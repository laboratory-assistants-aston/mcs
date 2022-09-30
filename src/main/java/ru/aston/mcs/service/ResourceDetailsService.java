package ru.aston.mcs.service;

import ru.aston.mcs.dto.ResourceDetailsDTO;

import java.util.List;

public interface ResourceDetailsService {
    List<ResourceDetailsDTO> getAllResourceDetails();

    void addAndSaveResourceDetails(ResourceDetailsDTO resourceDetailsDTO);

    void deleteResourceDetails(Long detailsId);

    ResourceDetailsDTO getResourceDetails(Long detailsId);
}
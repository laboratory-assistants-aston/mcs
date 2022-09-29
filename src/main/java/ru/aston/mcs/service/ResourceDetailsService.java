package ru.aston.mcs.service;

import ru.aston.mcs.entity.ResourceDetails;

import java.util.List;

public interface ResourceDetailsService {
    List<ResourceDetails> getAllResourceDetails();

    void saveResourceDetails(ResourceDetails resourceDetails);

    void deleteResourceDetails(int detailsId);

    ResourceDetails getResourceDetails(int detailsId);
}
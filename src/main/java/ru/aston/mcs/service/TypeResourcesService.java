package ru.aston.mcs.service;

import ru.aston.mcs.dto.TypeResourcesDTO;

import java.util.List;

public interface TypeResourcesService {

    List<TypeResourcesDTO> getAllTypeResources();

    void addAndSaveTypeResources(TypeResourcesDTO typeResourcesDTO);

    void deleteTypeResources(Long nameId);

    TypeResourcesDTO getTypeResources(Long nameId);
}
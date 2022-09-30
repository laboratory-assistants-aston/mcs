package ru.aston.mcs.service;

import ru.aston.mcs.entity.TypeResources;

import java.util.List;

public interface TypeResourcesService {
    List<TypeResources> getAllTypeResources();

    void saveTypeResources(TypeResources typeResources);

    void deleteTypeResources(Long nameId);

    TypeResources getTypeResources(Long nameId);
}
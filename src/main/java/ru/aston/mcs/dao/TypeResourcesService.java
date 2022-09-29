package ru.aston.mcs.dao;

import ru.aston.mcs.entity.TypeResources;

import java.util.List;

public interface TypeResourcesService {
    List<TypeResources> getAllTypeResources();

    void saveTypeResources(TypeResources typeResources);

    void deleteTypeResources(int nameId);

    TypeResources getTypeResources(int nameId);
}
package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.service.TypeResourcesService;
import ru.aston.mcs.entity.TypeResources;
import ru.aston.mcs.repository.TypeResourcesRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TypeResourcesServicesImpl implements TypeResourcesService {

    public final TypeResourcesRepository typeResourcesRepository;

    public TypeResourcesServicesImpl(TypeResourcesRepository typeResourcesRepository) {
        this.typeResourcesRepository = typeResourcesRepository;
    }

    @Override
    @Transactional
    public List<TypeResources> getAllTypeResources() {
        return typeResourcesRepository.findAll();
    }

    @Override
    @Transactional
    public void saveTypeResources(TypeResources typeResources) {
        typeResourcesRepository.save(typeResources);
    }

    @Override
    @Transactional
    public void deleteTypeResources(int nameId) {
        typeResourcesRepository.deleteById(nameId);
    }

    @Override
    @Transactional
    public TypeResources getTypeResources(int nameId) {
        TypeResources typeResources = null;
        Optional<TypeResources> typeResourcesOptional = typeResourcesRepository.findById(nameId);

        if (typeResourcesOptional.isPresent()){
            typeResources = typeResourcesOptional.get();
        }
        return typeResources;
    }
}

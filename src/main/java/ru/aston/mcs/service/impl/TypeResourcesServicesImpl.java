package ru.aston.mcs.service.Impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.TypeResourcesDTO;
import ru.aston.mcs.mapper.TypeResourcesMapper;
import ru.aston.mcs.repository.TypeResourcesRepository;
import ru.aston.mcs.service.TypeResourcesService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TypeResourcesServicesImpl implements TypeResourcesService {

    private final TypeResourcesRepository typeResourcesRepository;
    private final TypeResourcesMapper typeResourcesMapper;

    public TypeResourcesServicesImpl(TypeResourcesRepository typeResourcesRepository, TypeResourcesMapper typeResourcesMapper) {
        this.typeResourcesRepository = typeResourcesRepository;
        this.typeResourcesMapper = typeResourcesMapper;
    }

    @Override
    public List<TypeResourcesDTO> getAllTypeResources() {
        return typeResourcesMapper.toDTOList(typeResourcesRepository.findAll());
    }

    @Override
    public TypeResourcesDTO getTypeResources(Long nameId) {

        return typeResourcesMapper.toDTO(
                typeResourcesRepository.findById(nameId)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public void addAndSaveTypeResources(TypeResourcesDTO typeResourcesDTO) {

        typeResourcesRepository.save(typeResourcesMapper.toModel(typeResourcesDTO));
    }

    @Override
    public void deleteTypeResources(Long nameId) {
        typeResourcesRepository.deleteById(nameId);
    }

}

package ru.aston.mcs.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.aston.mcs.dto.ResourceTypeDTO;
import ru.aston.mcs.entity.ResourceType;
import ru.aston.mcs.mapper.ResourceTypeMapper;
import ru.aston.mcs.repository.ResourceTypeRepository;
import ru.aston.mcs.service.impl.ResourceTypeServicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ResourceTypeServicesImplTest {

    @Mock
    private ResourceTypeRepository resourceTypeRepository;

    @Mock
    private ResourceTypeMapper resourceTypeMapper;

    @InjectMocks
    private ResourceTypeServicesImpl resourceTypeServices;

    @Test
    void testGetAllResourceTypes() {

        List<ResourceTypeDTO> dto = new ArrayList<>();
        dto.add(new ResourceTypeDTO(1L, "parking",100.00));
        dto.add(new ResourceTypeDTO(2L, "co-working",50.00));


        List<ResourceType> entity = new ArrayList<>();
        entity.add(new ResourceType(1L, "parking",100.00));
        entity.add(new ResourceType(2L, "co-working",50.00));

        Mockito.when(resourceTypeRepository.findAll()).thenReturn(entity);
        Mockito.when(resourceTypeMapper.toDTOList(entity)).thenReturn(dto);

        List<ResourceTypeDTO> fromDb = resourceTypeServices.getAllResourceTypes();

        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals(fromDb.size(), entity.size());

        Mockito.verify(resourceTypeRepository).findAll();
        Mockito.verify(resourceTypeMapper).toDTOList(entity);

    }

    @Test
    void testGetResourceType() {

        ResourceType entity = new ResourceType(1L, "co-working", 100.00);
        ResourceTypeDTO dtoFromDb = new ResourceTypeDTO(1L, "co-working", 100.00);


        Mockito.when(resourceTypeRepository.findById(entity.getNameId())).thenReturn(Optional.of(entity));
        Mockito.when(resourceTypeMapper.toDTO(entity)).thenReturn(dtoFromDb);

        ResourceTypeDTO fromDb = resourceTypeServices.getResourceType(entity.getNameId());

        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals(fromDb.getNameId(), entity.getNameId());
        Assertions.assertEquals(fromDb.getName(), entity.getName());
        Assertions.assertEquals(fromDb.getCost(), entity.getCost());

        Mockito.verify(resourceTypeRepository).findById(entity.getNameId());
        Mockito.verify(resourceTypeMapper).toDTO(entity);
    }

    @Test
    void testCreateResourceType() {

        ResourceTypeDTO dtoToDb = new ResourceTypeDTO(null, "co-working", 100.00);
        ResourceType entity = new ResourceType(1L, "co-working", 100.00);

        ResourceTypeDTO dtoFromDb = new ResourceTypeDTO(1L, "co-working", 100.00);
        Mockito.when(resourceTypeRepository.save(resourceTypeMapper.toModel(dtoToDb))).thenReturn(entity);
        Mockito.when(resourceTypeMapper.toDTO(entity)).thenReturn(dtoFromDb);

        resourceTypeServices.createResourceType(dtoToDb);

        Mockito.verify(resourceTypeRepository).save(resourceTypeMapper.toModel(dtoToDb));
    }


    @Test
    void updateResourceType() {

        ResourceTypeDTO dto = new ResourceTypeDTO(null, "parking", 40.00);
        ResourceType changeEntity = new ResourceType(1L, "co-working", 10.00);
        ResourceType updatedEntity = new ResourceType(1L,  "parking", 40.00);

        Mockito.when(resourceTypeRepository.findById(changeEntity.getNameId())).thenReturn(Optional.of(changeEntity));
        Mockito.when(resourceTypeRepository.save(updatedEntity)).thenReturn(updatedEntity);

        resourceTypeServices.updateResourceType(changeEntity.getNameId(), dto);

        Mockito.verify(resourceTypeRepository).findById(changeEntity.getNameId());
        Mockito.verify(resourceTypeRepository).save(changeEntity);

    }


    @Test
    void testDeleteResourceType() {

        List<ResourceTypeDTO> dto = new ArrayList<>();
        dto.add(new ResourceTypeDTO(1L, "parking",100.00));
        dto.add(new ResourceTypeDTO(2L, "co-working",50.00));


        List<ResourceType> entity = new ArrayList<>();
        entity.add(new ResourceType(1L, "parking",100.00));
        entity.add(new ResourceType(2L, "co-working",50.00));


        Mockito.when(resourceTypeRepository.findById(entity.get(0).getNameId())).thenReturn(Optional.of(entity.get(0)));
        Mockito.doNothing().when(resourceTypeRepository).deleteById(entity.get(0).getNameId());

        resourceTypeServices.deleteResourceType(dto.get(0).getNameId());

        Mockito.verify(resourceTypeRepository).findById(dto.get(0).getNameId());
        Mockito.verify(resourceTypeRepository).deleteById(dto.get(0).getNameId());
    }
}
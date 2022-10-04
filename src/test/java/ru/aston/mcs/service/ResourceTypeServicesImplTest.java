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
import ru.aston.mcs.util.ResourceTypeDataUtils;
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

        //Arrange
        List<ResourceType> entity = ResourceTypeDataUtils.createResourceTypeEntityList();
        List<ResourceTypeDTO> dto = ResourceTypeDataUtils.createResourceTypeDTOList();
        Mockito.when(resourceTypeRepository.findAll()).thenReturn(entity);
        Mockito.when(resourceTypeMapper.toDTOList(entity)).thenReturn(dto);

        //Action
        List<ResourceTypeDTO> fromDb = resourceTypeServices.getAllResourceTypes();

        //Assert
        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals(fromDb.size(), entity.size());

        Mockito.verify(resourceTypeRepository).findAll();
        Mockito.verify(resourceTypeMapper).toDTOList(entity);

    }

    @Test
    void testGetResourceType() {

        //Arrange
        ResourceType entity = ResourceTypeDataUtils.createResourceTypeEntity();
        ResourceTypeDTO dto = ResourceTypeDataUtils.createResourceTypeDTO();
        Mockito.when(resourceTypeRepository.findById(entity.getNameId())).thenReturn(Optional.of(entity));
        Mockito.when(resourceTypeMapper.toDTO(entity)).thenReturn(dto);

        //Action
        ResourceTypeDTO fromDb = resourceTypeServices.getResourceType(entity.getNameId());

        //Assert
        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals(fromDb.getNameId(), entity.getNameId());
        Assertions.assertEquals(fromDb.getName(), entity.getName());
        Assertions.assertEquals(fromDb.getCost(), entity.getCost());

        Mockito.verify(resourceTypeRepository).findById(entity.getNameId());
        Mockito.verify(resourceTypeMapper).toDTO(entity);
    }

    @Test
    void testAddAndSaveResourceType() {

        //Arrange
        ResourceType entity = ResourceTypeDataUtils.createResourceTypeEntity();
        ResourceTypeDTO dto = ResourceTypeDataUtils.createResourceTypeDTO();
        Mockito.when(resourceTypeMapper.toModel(dto)).thenReturn(entity);
        Mockito.when(resourceTypeRepository.save(entity)).thenReturn(entity);

        //Action
        resourceTypeServices.addAndSaveResourceType(dto);

        //Assert
        Mockito.verify(resourceTypeMapper).toModel(dto);
        Mockito.verify(resourceTypeRepository).save(entity);

    }

    @Test
    void testDeleteResourceType() {

        //Arrange
        ResourceTypeDTO dto = ResourceTypeDataUtils.createResourceTypeDTO();

        //Action
        resourceTypeServices.deleteResourceType(dto.getNameId());

        //Assert
        Mockito.verify(resourceTypeRepository).deleteById(dto.getNameId());
    }
}
package ru.aston.mcs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Profile;
import ru.aston.mcs.dto.ResourceDTO;
import ru.aston.mcs.mapper.ResourceMapper;
import ru.aston.mcs.repository.ResourceRepository;
import ru.aston.mcs.service.impl.ResourceServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@Profile("test")
class ResourceServiceImplTest {
    @Mock
    private ResourceRepository resourceRepository;

    @InjectMocks
    private ResourceServiceImpl resourceServiceImpl;
    @Mock
    ResourceMapper resourceMapper;

    private ResourceDTO resourceDTO;

    @BeforeEach
    void createDto() {
        resourceDTO = new ResourceDTO();
        resourceDTO.setId(0L);
        resourceDTO.setResourceIdentifier("");
        resourceDTO.setResourceType(null);
        resourceDTO.setBookingResourceList(null);
    }

    @Test
    void getAllResourceTest() {
        resourceServiceImpl.getAllResource();
        Mockito.verify(resourceRepository).findAll();
    }

    @Test
    void getResourceByIdTest() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> resourceServiceImpl.getResource(0L));
        Mockito.verify(resourceRepository).findById(0L);
    }

    @Test
    void createResourceFromDtoTest() {
        resourceServiceImpl.create(resourceDTO);
        Mockito.verify(resourceRepository).save(resourceMapper.toModel(resourceDTO));
    }

    @Test
    void deleteResourceByIdTest() {

        resourceServiceImpl.deleteResource(1L);
        Mockito.verify(resourceRepository).deleteById(1L);

    }
}
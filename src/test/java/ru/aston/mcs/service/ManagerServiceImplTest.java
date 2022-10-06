package ru.aston.mcs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.mcs.dto.ManagerDTO;
import ru.aston.mcs.mapper.ManagerMapper;
import ru.aston.mcs.repository.ManagerRepository;
import ru.aston.mcs.service.impl.ManagerServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ManagerServiceImplTest {
    @Mock
    private ManagerRepository managerRepository;
    @Mock
    private ManagerMapper managerMapper;

    @InjectMocks
    private ManagerServiceImpl managerService;

    private ManagerDTO managerDTO;

    @BeforeEach
    void createDto() {
        managerDTO = new ManagerDTO();
        managerDTO.setJobTitle("jobTitle");
        managerDTO.setName("name");
        managerDTO.setPerson(null);
        managerDTO.setSurname("surname");
    }

    @Test
    public void getAllManagersTest() {
        managerService.getAllManagers();
        Mockito.verify(managerRepository).findAll();
    }

    @Test
    public void getManagerByIdTest() {
        RuntimeException runtimeException =
                assertThrows(RuntimeException.class, () -> managerService.getManager(2L));
        Mockito.verify(managerRepository).findById(2L);
    }

    @Test
    public void createManagerFromDtoTest() {
        managerService.addAndSaveManager(managerDTO);
        Mockito.verify(managerRepository).save(managerMapper.toModel(managerDTO));
    }

    @Test
    public void deleteManagerByIdTest() {
        managerService.deleteManager(1L);
        Mockito.verify(managerRepository).deleteById(1L);
    }
}

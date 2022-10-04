package ru.aston.mcs;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.aston.mcs.dto.ManagerDTO;
import ru.aston.mcs.dto.RolesDTO;
import ru.aston.mcs.entity.Manager;
import ru.aston.mcs.repository.ManagerRepository;
import ru.aston.mcs.service.ManagerService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerServiceImplTest {
    @SpyBean
    private ManagerService managerService;
    @MockBean
    private ManagerRepository managerRepository;

    @Before
    public void setUp() {
        Manager manager = new Manager(1L,null ,
                "Alex", "Worker", "Surname");
        Manager manager2 = new Manager(2L,null ,
                "Alex2", "Worker2", "Surname2");
        Manager manager3 = new Manager(3L,null ,
                "Alex3", "Worker3", "Surname3");
        Mockito.when(managerRepository.findById(manager.getId())).thenReturn(Optional.of(manager));
        Mockito.when(managerRepository.findAll()).thenReturn(List.of(manager, manager2, manager3));
    }

    @Test
    public void whenValidId_thenManagerShouldBeFound() {
        Long id = 1L;
        ManagerDTO found = managerService.getManager(1L);

        assertThat(found.getId()).isEqualTo(id);
    }

    @Test
    public void whenFindAll_then3ManagersShouldBeFound() {
        List<ManagerDTO> managerList = managerService.getAllManagers();

        assertThat(managerList).isNotNull();
        assertThat(managerList.size()).isEqualTo(3);
    }

    @Test
    public void whenDeleteById_thenNothingShouldReturn() {
        long id = 1L;

        willDoNothing().given(managerRepository).deleteById(id);

        managerService.deleteManager(id);

        verify(managerRepository, times(1)).deleteById(id);
    }

    @Test(expected = RuntimeException.class)
    public void whenInvalidId_thenThrowException() {
        Long id = 0L;
        Mockito.when(managerRepository.findById(id)).thenReturn(Optional.empty());
        ManagerDTO found = managerService.getManager(0L);
        verify(managerRepository, times(1)).findById(id);
    }
}

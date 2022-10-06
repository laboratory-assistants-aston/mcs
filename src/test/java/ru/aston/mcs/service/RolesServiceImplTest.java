package ru.aston.mcs.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.aston.mcs.dto.RolesDTO;
import ru.aston.mcs.dto.UserDTO;
import ru.aston.mcs.entity.Role;
import ru.aston.mcs.mapper.RolesMapper;
import ru.aston.mcs.repository.RolesRepository;
import ru.aston.mcs.service.RolesService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RolesServiceImplTest {
    @SpyBean
    private RolesService rolesService;
    @MockBean
    private RolesRepository rolesRepository;

    @Before
    public void setUp() {
        Role role = new Role(1L, "name", null);
        Role role2 = new Role(2L, "name2", null);
        Role role3 = new Role(3L, "name3", null);
        Mockito.when(rolesRepository.findById(role.getId())).thenReturn(Optional.of(role));
        Mockito.when(rolesRepository.findAll()).thenReturn(List.of(role, role2, role3));
    }

    @Test
    public void whenValidId_thenRoleShouldBeFound() {
        Long id = 1L;
        RolesDTO found = rolesService.getRole(1L);

        assertThat(found.getId()).isEqualTo(id);
    }

    @Test
    public void whenFindAll_then3RolesShouldBeFound() {
        List<RolesDTO> rolesList = rolesService.getAllRoles();

        assertThat(rolesList).isNotNull();
        assertThat(rolesList.size()).isEqualTo(3);
    }

    @Test
    public void whenDeleteById_thenNothingShouldReturn() {
        long id = 1L;

        willDoNothing().given(rolesRepository).deleteById(id);

        rolesService.deleteRole(id);

        verify(rolesRepository, times(1)).deleteById(id);
    }

    @Test(expected = RuntimeException.class)
    public void whenInvalidId_thenThrowException() {
        Long id = 0L;
        Mockito.when(rolesRepository.findById(id)).thenReturn(Optional.empty());
        RolesDTO found = rolesService.getRole(0L);
        verify(rolesRepository, times(1)).findById(id);
    }
}

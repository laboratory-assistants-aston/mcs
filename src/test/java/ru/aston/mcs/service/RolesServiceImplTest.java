package ru.aston.mcs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.mcs.dto.RolesDTO;
import ru.aston.mcs.mapper.RolesMapper;
import ru.aston.mcs.repository.RolesRepository;
import ru.aston.mcs.service.Impl.RolesServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class RolesServiceImplTest {
    @Mock
    private RolesRepository rolesRepository;
    @Mock
    private RolesMapper rolesMapper;

    @InjectMocks
    private RolesServiceImpl rolesService;

    private RolesDTO rolesDTO;

    @BeforeEach
    void createDto() {
        rolesDTO = new RolesDTO();
        rolesDTO.setRoleName("roleName");
        rolesDTO.setPersons(null);
    }

    @Test
    void getAllRolesTest() {
        rolesService.getAllRoles();
        Mockito.verify(rolesRepository).findAll();
    }

    @Test
    void getRoleByIdTest() {
        RuntimeException runtimeException =
                assertThrows(RuntimeException.class, () -> rolesService.getRole(1L));
        Mockito.verify(rolesRepository).findById(1L);
    }

    @Test
    void createRoleFromDtoTest() {
        rolesService.addAndSaveRole(rolesDTO);
        Mockito.verify(rolesRepository).save(rolesMapper.toModel(rolesDTO));
    }

    @Test
    void deleteRoleByIdTest() {
        rolesService.deleteRole(1L);
        Mockito.verify(rolesRepository).deleteById(1L);
    }
}

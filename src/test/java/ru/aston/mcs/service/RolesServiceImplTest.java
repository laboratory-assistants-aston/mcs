package ru.aston.mcs.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.mcs.dto.RolesDTO;
import ru.aston.mcs.entity.Role;
import ru.aston.mcs.entity.enums.ERole;
import ru.aston.mcs.mapper.RolesMapper;
import ru.aston.mcs.repository.RolesRepository;
import ru.aston.mcs.service.impl.RolesServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

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
        rolesDTO.setRoleName(ERole.ROLE_USER);
        //  rolesDTO.setUsers(null);
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
        rolesService.createRole(rolesDTO);
        Mockito.verify(rolesRepository).save(rolesMapper.toModel(rolesDTO));
    }

    @Test
    void updateRoleFromDtoTest() {
/*        Role roleFromDb = new Role(1L, "rolename1", null);
        RolesDTO result = new RolesDTO(1L, "upd", null);*/
        Role roleFromDb = new Role(ERole.ROLE_USER);
        RolesDTO result = new RolesDTO(ERole.ROLE_ADMIN);

        Mockito.when(rolesRepository.findById(anyLong())).thenReturn(Optional.of(roleFromDb));
        Mockito.when(rolesRepository.save(any(Role.class))).thenReturn(roleFromDb);

        rolesService.updateRole(1L, result);
        Assertions.assertEquals(roleFromDb.getRoleName(), result.getRoleName());
        Assertions.assertEquals(roleFromDb.getRoleId(), result.getId());

        Mockito.verify(rolesRepository).save(any(Role.class));
    }

    @Test
    void deleteRoleByIdTest() {
        rolesService.deleteRole(1L);
        Mockito.verify(rolesRepository).deleteById(1L);
    }
}

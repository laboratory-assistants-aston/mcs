package ru.aston.mcs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.mcs.dto.UserDTO;
import ru.aston.mcs.mapper.UserMapper;
import ru.aston.mcs.repository.UserRepository;
import ru.aston.mcs.service.impl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    private UserDTO userDTO;

    @BeforeEach
    void createDto() {
        userDTO = new UserDTO();
        userDTO.setAccessCode(123);
        userDTO.setEmail("email@mail.ru");
        userDTO.setLogin("login");
        userDTO.setRoles(null);
    }


    @Test
    void getAllUsersTest() {
        userService.getAllUsers();
        Mockito.verify(userRepository).findAll();
    }

    @Test
    void getUserByIdTest() {
        RuntimeException runtimeException =
                assertThrows(RuntimeException.class, () -> userService.getUser(1L));
        Mockito.verify(userRepository).findById(1L);
    }

    @Test
    void createUserFromDtoTest() {
        userService.addAndSaveUser(userDTO);
        Mockito.verify(userRepository).save(userMapper.toModel(userDTO));
    }

    @Test
    void deleteUserByIdTest() {
        userService.deleteUser(1L);
        Mockito.verify(userRepository).deleteById(1L);
    }
}

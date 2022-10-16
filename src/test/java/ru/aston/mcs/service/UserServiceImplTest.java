package ru.aston.mcs.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.mcs.dto.UserDTO;
import ru.aston.mcs.entity.User;
import ru.aston.mcs.mapper.UserMapper;
import ru.aston.mcs.repository.UserRepository;
import ru.aston.mcs.service.impl.UserServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

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
        userDTO = new UserDTO("username", "password", 123, "email", "phone", "address", 2.2F, null);
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
        userService.createUser(userDTO);
        Mockito.verify(userRepository).save(userMapper.toModel(userDTO));
    }

    @Test
    void updateUserFromDtoTest() {
        User userFromDb = new User( "username", "password", 123, "email", "phone", "address", 2.2F, null);
        UserDTO result = new UserDTO("updeteUsername", "password", 123, "email", "phone", "address", 2.2F, null);

        Mockito.when(userRepository.findById(anyLong())).thenReturn(Optional.of(userFromDb));
        Mockito.when(userRepository.save(any(User.class))).thenReturn(userFromDb);

        userService.updateUser(1L, result);
        Assertions.assertEquals(userFromDb.getUsername(), result.getUserName());
        Assertions.assertEquals(userFromDb.getEmail(), result.getEmail());
        Mockito.verify(userRepository).save(any(User.class));
    }

    @Test
    void deleteUserByIdTest() {
        userService.deleteUser(1L);
        Mockito.verify(userRepository).deleteById(1L);
    }
}

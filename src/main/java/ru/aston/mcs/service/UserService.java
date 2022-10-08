package ru.aston.mcs.service;

import ru.aston.mcs.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUser(Long userId);

    void saveUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);

    void deleteUser(Long userId);
}


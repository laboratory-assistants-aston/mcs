package ru.aston.mcs.service;

import ru.aston.mcs.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUser(Long userId);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long userId);

    void fillUserBalance(Long id, Float amount);
}


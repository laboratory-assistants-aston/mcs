package ru.aston.mcs.service;

import ru.aston.mcs.dto.UsersDTO;

import java.util.List;

public interface UsersService {
    List<UsersDTO> getAllUser();

    UsersDTO getUser(Long id);

    void createUser(UsersDTO user);

    void deleteUser(Long id);
}

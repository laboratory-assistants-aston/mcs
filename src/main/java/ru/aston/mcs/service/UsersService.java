package ru.aston.mcs.service;

import ru.aston.mcs.dto.UsersDTO;

public interface UsersService {
    UsersDTO getUser(Long id);

    void addAndSaveUser(UsersDTO userDto);

    void deleteUser(Long id);
}

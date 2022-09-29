package ru.aston.mcs.services;

import ru.aston.mcs.dto.UsersDto;

public interface UsersService {
    UsersDto getUser(Long id);

    void addAndSaveUser(UsersDto userDto);

    void deleteUser(Long id);
}
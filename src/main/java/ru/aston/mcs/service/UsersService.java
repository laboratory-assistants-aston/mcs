package ru.aston.mcs.service;

import ru.aston.mcs.entity.Users;

public interface UsersService {
    Users getUser(Long id);

    void addAndSaveUser(Users user);

    void deleteUser(Long id);
}

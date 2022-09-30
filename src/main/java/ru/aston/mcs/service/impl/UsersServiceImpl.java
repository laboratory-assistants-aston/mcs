package ru.aston.mcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.UsersDTO;
import ru.aston.mcs.entity.Users;
import ru.aston.mcs.mapper.UsersMapper;
import ru.aston.mcs.repository.UsersRepository;
import ru.aston.mcs.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;


    @Override
    @Transactional
    public Users getUser(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void addAndSaveUser(Users user) {
        usersRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}

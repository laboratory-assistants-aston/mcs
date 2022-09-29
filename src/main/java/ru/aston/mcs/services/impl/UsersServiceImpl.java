package ru.aston.mcs.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.UsersDto;
import ru.aston.mcs.mapper.UsersMapper;
import ru.aston.mcs.repositories.UsersRepository;
import ru.aston.mcs.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UsersDto getUser(Long id) {
        return usersMapper.usersInUsersDto(usersRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public void addAndSaveUser(UsersDto userDto) {

        usersRepository.save(usersMapper.usersDtoInUsers(userDto));
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);

    }
}

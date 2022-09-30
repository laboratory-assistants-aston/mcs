package ru.aston.mcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.UsersDTO;
import ru.aston.mcs.mapper.UsersMapper;
import ru.aston.mcs.service.UsersService;

@RestController("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @Autowired
    UsersMapper usersMapper;

    @GetMapping("/")
    public UsersDTO getUser(@PathVariable Long id) {
        return usersMapper.usersInUsersDto(usersService.getUser(id));
    }

    @PostMapping("/")
    public void saveUser(@RequestBody UsersDTO usersDto) {
        usersService.addAndSaveUser(usersMapper.usersDtoInUsers(usersDto));
    }

    @DeleteMapping("/")
    public void deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
    }
}

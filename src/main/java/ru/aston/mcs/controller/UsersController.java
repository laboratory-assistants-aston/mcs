package ru.aston.mcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.UsersDto;
import ru.aston.mcs.services.UsersService;

@RestController
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("/user")
    public UsersDto getUser(@PathVariable Long id) {
        return usersService.getUser(id);
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UsersDto usersDto) {
        usersService.addAndSaveUser(usersDto);
    }

    @DeleteMapping("/user")
    public void deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
    }
}

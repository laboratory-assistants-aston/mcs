package ru.aston.mcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.UsersDTO;
import ru.aston.mcs.service.UsersService;

@RestController("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("/")
    public UsersDTO getUser(@PathVariable Long id) {
        return usersService.getUser(id);
    }

    @PostMapping("/")
    public void saveUser(@RequestBody UsersDTO usersDto) {
        usersService.addAndSaveUser(usersDto);
    }

    @DeleteMapping("/")
    public void deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
    }
}

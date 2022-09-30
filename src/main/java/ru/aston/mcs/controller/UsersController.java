package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.UsersDTO;
import ru.aston.mcs.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    public final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/")
    public List<UsersDTO> getAllUsers() {
        return usersService.getAllUser();
    }

    @GetMapping("/{id}")
    public UsersDTO getUser(@PathVariable Long id) {
        return usersService.getUser(id);
    }

    @PostMapping("/")
    public void saveUser(@RequestBody UsersDTO usersDto) {
        usersService.createUser(usersDto);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody UsersDTO usersDto) {
        usersService.createUser(usersDto);
    }

    @DeleteMapping("/")
    public void deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
    }
}

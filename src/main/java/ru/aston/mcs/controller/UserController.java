package ru.aston.mcs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.UserDTO;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Api(value = "User Controller", description = "CRUD operations for table Roles")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Get all users", notes = "Returns list of all users")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "all users found") })
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get user", notes = "Return user by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "User found") })
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/")
    @ApiOperation(value = "Create user", notes = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "New user was created") })
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        if (userDTO == null) {
            throw new InvalidRequestException();
        }
        return userService.createUser(userDTO);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update user", notes = "Update user by id and return UserDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "User was successfully updated") })
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete user", notes = "Delete user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "User was successfully deleted") })
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

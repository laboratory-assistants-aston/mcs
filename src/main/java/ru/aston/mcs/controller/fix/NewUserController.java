package ru.aston.mcs.controller.fix;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.mcs.dto.request.UserRequest;
import ru.aston.mcs.dto.response.UserResponse;
import ru.aston.mcs.service.fix.IUserService;

import java.util.List;

@Api(value = "User Controller", description = "CRUD operations for table Roles")
@RestController
@RequestMapping("api/v2/users")
public class NewUserController {

    private final IUserService userService;

    public NewUserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Get all users", notes = "Returns list of all users")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "all users found") })
    public List<UserResponse> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get user", notes = "Return user by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "User found") })
    public UserResponse getUser(@PathVariable Long id) {
        return userService.get(id);
    }

    @PostMapping("/")
    @ApiOperation(value = "Create user", notes = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "New user was created") })
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update user", notes = "Update user by id and return UserDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "User was successfully updated") })
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        return userService.update(id, userRequest);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete user", notes = "Delete user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "User was successfully deleted") })
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }


}

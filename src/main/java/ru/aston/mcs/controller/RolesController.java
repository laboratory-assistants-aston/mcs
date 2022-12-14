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
import ru.aston.mcs.dto.RolesDTO;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.service.RolesService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@Api(basePath = "/api/roles",
        value = "role",
        description = "CRUD-Operations with role table",
        produces = "application/json")
public class RolesController {

    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Get all roles", notes = "Return all roles")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "Roles successfully returned") })
    public List<RolesDTO> getAllRoles() {
        return rolesService.getAllRoles();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get role", notes = "Return role by id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "Role was successfully found") })
    public RolesDTO getRole(@PathVariable Long id) {
        return rolesService.getRole(id);
    }

    @PostMapping("/")
    @ApiOperation(value = "Create new role", notes = "Create new role and return roleDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "New user was successfully returned") })
    public void createRole(@RequestBody RolesDTO rolesDto) {
        if (rolesDto == null) {
            throw new InvalidRequestException();
        }
        rolesService.createRole(rolesDto);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update role", notes = "Update role by id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "Role was successfully updated") })
    public RolesDTO updateRole(@PathVariable Long id, @RequestBody RolesDTO rolesDto) {
        return rolesService.updateRole(id, rolesDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete role", notes = "Delete role by id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "Type resources deleted") })
    public void deleteRole(@PathVariable Long id) {
        rolesService.deleteRole(id);
    }
}

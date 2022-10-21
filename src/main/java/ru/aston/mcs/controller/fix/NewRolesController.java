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
import ru.aston.mcs.dto.request.RoleRequest;
import ru.aston.mcs.dto.response.RoleResponse;
import ru.aston.mcs.service.fix.IRolesService;

import java.util.List;

@Api(basePath = "api/v2/roles", value = "role",description = "CRUD-Operations with role table", produces = "application/json")
@RestController
@RequestMapping("api/v2/roles")
public class NewRolesController {

    private final IRolesService rolesService;

    public NewRolesController(IRolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Get all roles", notes = "Return all roles")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "Roles successfully returned") })
    public List<RoleResponse> getAllRoles() {
        return rolesService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get role", notes = "Return role by id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "Role was successfully found") })
    public RoleResponse getRole(@PathVariable Long id) {
        return rolesService.get(id);
    }

    @PostMapping("/")
    @ApiOperation(value = "Create new role", notes = "Create new role and return roleDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "New user was successfully returned") })
    public RoleResponse createRole(@RequestBody RoleRequest roleRequest) {
  /*      if (rolesDto == null) {
            throw new InvalidRequestException();
        }*/
        return rolesService.create(roleRequest);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update role", notes = "Update role by id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "Role was successfully updated") })
    public RoleResponse updateRole(@PathVariable Long id, @RequestBody RoleRequest roleRequest) {
        return rolesService.update(id, roleRequest);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete role", notes = "Delete role by id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 200, message = "Type resources deleted") })
    public void deleteRole(@PathVariable Long id) {
        rolesService.delete(id);
    }
}

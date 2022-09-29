package ru.aston.mcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.RoleDTO;
import ru.aston.mcs.entity.Role;
import ru.aston.mcs.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/{id}")
    public RoleDTO getRole(@PathVariable int id){
        return roleService.getRole(id);
    }

    @PostMapping("/")
    public void addNewRole(@RequestBody RoleDTO roleDTO){
        roleService.saveRole(roleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable int id){
        roleService.deleteRole(id);
    }
}

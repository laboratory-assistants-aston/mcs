package ru.aston.mcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.entity.Role;
import ru.aston.mcs.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Role> showAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable int id){
        return roleService.getRole(id);
    }

    @PostMapping("/")
    public Role addNewRole(@RequestBody Role role){
        roleService.saveRole(role);
        return role;
    }

    @PutMapping("/")
    public Role updateRole(@RequestBody Role role){
        roleService.saveRole(role);
        return role;
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable int id){
        roleService.deleteRole(id);
        return "Role " + id + "was deleted";
    }
}

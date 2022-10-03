package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.RolesDTO;
import ru.aston.mcs.service.RolesService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("/")
    public List<RolesDTO> getAllRoles() {
        return rolesService.getAllRoles();
    }

    @GetMapping("/{id}")
    public RolesDTO getRole(@PathVariable Long id) {
        return rolesService.getRole(id);
    }

    @PostMapping("/")
    public void addRole(@RequestBody RolesDTO rolesDto) {
        rolesService.addAndSaveRole(rolesDto);
    }

    @PutMapping("/")
    public void updateRole(@RequestBody RolesDTO rolesDto) {
        rolesService.addAndSaveRole(rolesDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        rolesService.deleteRole(id);
    }
}

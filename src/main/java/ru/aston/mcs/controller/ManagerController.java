package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.ManagerDTO;
import ru.aston.mcs.service.ManagerService;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/")
    public List<ManagerDTO> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/{id}")
    public ManagerDTO getManager(@PathVariable Long id) {
        return managerService.getManager(id);
    }

    @PostMapping("/")
    public void addNewManager(@RequestBody ManagerDTO managerDTO) {
        managerService.addAndSaveManager(managerDTO);
    }

    @PutMapping("/")
    public void updateManager(@RequestBody ManagerDTO managerDTO) {
        managerService.addAndSaveManager(managerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
    }
}

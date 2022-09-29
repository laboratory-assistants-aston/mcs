package ru.aston.mcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.ManagerDTO;
import ru.aston.mcs.entity.Manager;
import ru.aston.mcs.service.ManagerService;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/{id}")
    public ManagerDTO getManager(@PathVariable int id){
        return managerService.getManager(id);
    }

    @PostMapping("/")
    public void addNewManager(@RequestBody ManagerDTO managerDTO){
        managerService.saveManager(managerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable int id){
        managerService.deleteManager(id);
    }
}

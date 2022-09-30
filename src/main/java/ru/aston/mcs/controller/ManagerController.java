package ru.aston.mcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.ManagerDTO;
import ru.aston.mcs.mapper.ManagerMapper;
import ru.aston.mcs.service.ManagerService;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ManagerMapper managerMapper;

    @GetMapping("/{id}")
    public ManagerDTO getManager(@PathVariable int id){
        return managerMapper.managerInManagerDTO(managerService.getManager(id));
    }

    @PostMapping("/")
    public void addNewManager(@RequestBody ManagerDTO managerDTO){
        managerService.saveManager(managerMapper.managerDtoInManager(managerDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable int id){
        managerService.deleteManager(id);
    }
}

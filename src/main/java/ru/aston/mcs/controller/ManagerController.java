package ru.aston.mcs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.entity.Manager;
import ru.aston.mcs.service.ManagerService;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/")
    public List<Manager> showAllManagers(){
        return managerService.getAllManagers();
    }

    @GetMapping("/{id}")
    public Manager getManager(@PathVariable int id){
        return managerService.getManager(id);
    }

    @PostMapping("/")
    public Manager addNewManager(@RequestBody Manager manager){
        managerService.saveManager(manager);
        return manager;
    }

    @PutMapping("/")
    public Manager updateManager(@RequestBody Manager manager){
        managerService.saveManager(manager);
        return manager;
    }

    @DeleteMapping("/{id}")
    public String deleteManager(@PathVariable int id){
        managerService.deleteManager(id);
        return "Manager " + id + "was deleted";
    }
}

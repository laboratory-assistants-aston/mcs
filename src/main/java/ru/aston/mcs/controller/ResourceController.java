package ru.aston.mcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.ResourcesDTO;
import ru.aston.mcs.service.ResourcesServices;

@RestController
public class ResourceController {
    @Autowired
    ResourcesServices resourcesServices;

    @GetMapping("/resource")
    public ResourcesDTO getUser(@PathVariable Long id) {
        return resourcesServices.getResource(id);
    }

    @PostMapping("/resource")
    public void saveUser(@RequestBody ResourcesDTO resourcesDto) {
        resourcesServices.addAndSaveResource(resourcesDto);
    }

    @DeleteMapping("/resource")
    public void deleteUser(@PathVariable Long id) {
        resourcesServices.deleteResource(id);
    }
}

package ru.aston.mcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.ResourcesDTO;
import ru.aston.mcs.mapper.ResourcesMapper;
import ru.aston.mcs.service.ResourcesServices;

@RestController
public class ResourceController {
    @Autowired
    ResourcesServices resourcesServices;

    @Autowired
    private ResourcesMapper resourcesMapper;

    @GetMapping("/resource")
    public ResourcesDTO getUser(@PathVariable Long id) {
        return resourcesMapper.resourceInResourceDto(resourcesServices.getResource(id));
    }

    @PostMapping("/resource")
    public void saveUser(@RequestBody ResourcesDTO resourcesDto) {
        resourcesServices.addAndSaveResource(resourcesMapper.resourceDtoInResource(resourcesDto));
    }

    @DeleteMapping("/resource")
    public void deleteUser(@PathVariable Long id) {
        resourcesServices.deleteResource(id);
    }
}

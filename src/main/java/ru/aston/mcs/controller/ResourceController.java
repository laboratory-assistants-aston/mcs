package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.ResourceDTO;
import ru.aston.mcs.service.ResourceServices;

import java.util.List;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {
    private final ResourceServices resourcesServices;

    public ResourceController(ResourceServices resourcesServices) {
        this.resourcesServices = resourcesServices;
    }

    @GetMapping("/")
    public List<ResourceDTO> getAllTypeResources() {
        return resourcesServices.getAllResources();
    }

    @GetMapping("/{id}")
    public ResourceDTO getUser(@PathVariable Long id) {
        return resourcesServices.getResource(id);
    }

    @PostMapping("/")
    public void saveUser(@RequestBody ResourceDTO resourcesDto) {
        resourcesServices.addAndSaveResource(resourcesDto);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody ResourceDTO resourceDto) {
        resourcesServices.addAndSaveResource(resourceDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        resourcesServices.deleteResource(id);
    }
}

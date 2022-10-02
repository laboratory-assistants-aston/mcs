package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.ResourceDTO;
import ru.aston.mcs.service.ResourceServices;

import java.util.List;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {
    final
    ResourceServices resourceServices;

    public ResourceController(ResourceServices resourceServices) {
        this.resourceServices = resourceServices;
    }

    @GetMapping("/")
    public List<ResourceDTO> getAllTypeResources() {
        return resourceServices.getAllResources();
    }

    @GetMapping("/{id}")
    public ResourceDTO getUser(@PathVariable Long id) {
        return resourceServices.getResource(id);
    }

    @PostMapping("/")
    public void saveUser(@RequestBody ResourceDTO resourceDto) {
        resourceServices.addAndSaveResource(resourceDto);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody ResourceDTO resourceDto) {
        resourceServices.addAndSaveResource(resourceDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        resourceServices.deleteResource(id);
    }
}

package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.ResourcesDTO;
import ru.aston.mcs.service.ResourcesServices;

import java.util.List;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {
    final
    ResourcesServices resourcesServices;

    public ResourceController(ResourcesServices resourcesServices) {
        this.resourcesServices = resourcesServices;
    }

    @GetMapping("/")
    public List<ResourcesDTO> getAllTypeResources() {
        return resourcesServices.getAllResources();
    }

    @GetMapping("/{id}")
    public ResourcesDTO getUser(@PathVariable Long id) {
        return resourcesServices.getResource(id);
    }

    @PostMapping("/")
    public void saveUser(@RequestBody ResourcesDTO resourcesDto) {
        resourcesServices.addAndSaveResource(resourcesDto);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody ResourcesDTO resourcesDto) {
        resourcesServices.addAndSaveResource(resourcesDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        resourcesServices.deleteResource(id);
    }
}

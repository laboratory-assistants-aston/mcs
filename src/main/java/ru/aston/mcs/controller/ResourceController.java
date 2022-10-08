package ru.aston.mcs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.ResourceDTO;
import ru.aston.mcs.service.ResourceService;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/")
    public List<ResourceDTO> getAllResources() {
        return resourceService.getAllResource();
    }

    @GetMapping("/{id}")
    public ResourceDTO getResources(@PathVariable Long id) {
        return resourceService.getResource(id);
    }

    @PostMapping("/")
    public ResponseEntity<Void> addResources(@RequestBody ResourceDTO ResourcesDto) {
        resourceService.addAndSaveResource(ResourcesDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateResources(@RequestBody ResourceDTO ResourcesDto) {
        resourceService.addAndSaveResource(ResourcesDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResources(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return ResponseEntity.ok().build();
    }
}

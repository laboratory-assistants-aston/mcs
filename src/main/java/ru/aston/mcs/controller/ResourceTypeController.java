package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.ResourceTypeDTO;
import ru.aston.mcs.service.ResourceTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/resource-types")
public class ResourceTypeController {

    private final ResourceTypeService typeResourcesService;

    public ResourceTypeController(ResourceTypeService typeResourcesService) {
        this.typeResourcesService = typeResourcesService;
    }

    @GetMapping("/")
    public List<ResourceTypeDTO> getAllTypeResources() {
        return typeResourcesService.getAllResourceTypes();
    }

    @GetMapping("/{id}")
    public ResourceTypeDTO getTypeResources(@PathVariable Long id) {
        return typeResourcesService.getResourceType(id);
    }

    @PostMapping("/")
    public void addTypeResources(@RequestBody ResourceTypeDTO typeResourcesDto) {
        typeResourcesService.saveResourceType(typeResourcesDto);
    }

    @PutMapping("/")
    public void updateTypeResources(@RequestBody ResourceTypeDTO typeResourcesDto) {
        typeResourcesService.updateResourceType(typeResourcesDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTypeResources(@PathVariable Long id) {
        typeResourcesService.deleteResourceType(id);
    }
}
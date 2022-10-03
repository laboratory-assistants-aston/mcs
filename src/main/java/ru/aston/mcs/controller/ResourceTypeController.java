package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

        typeResourcesService.addAndSaveResourceType(typeResourcesDto);
    }

    @PutMapping("/")
    public void updateTypeResources(@RequestBody ResourceTypeDTO typeResourcesDto) {

        typeResourcesService.addAndSaveResourceType(typeResourcesDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTypeResources(@PathVariable Long id) {

        typeResourcesService.deleteResourceType(id);
    }
}
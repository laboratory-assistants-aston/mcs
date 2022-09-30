package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.ResourceDetailsDTO;
import ru.aston.mcs.service.ResourceDetailsService;

import java.util.List;

@RestController
@RequestMapping("/api/resource-details")
public class ResourceDetailsController {

    public final ResourceDetailsService resourceDetailsService;


    public ResourceDetailsController(ResourceDetailsService resourceDetailsService) {
        this.resourceDetailsService = resourceDetailsService;
    }

    @GetMapping("/")
    public List<ResourceDetailsDTO> getAllTypeResources() {

        return resourceDetailsService.getAllResourceDetails();
    }

    @GetMapping("/{id}")
    public ResourceDetailsDTO getTypeResources(@PathVariable Long id) {

        return resourceDetailsService.getResourceDetails(id);
    }

    @PostMapping("/")
    public void addTypeResources(@RequestBody ResourceDetailsDTO resourceDetailsDTO) {
        resourceDetailsService.addAndSaveResourceDetails(resourceDetailsDTO);
    }

    @PutMapping("/")
    public void updateTypeResources(@RequestBody ResourceDetailsDTO resourceDetailsDTO) {
        resourceDetailsService.addAndSaveResourceDetails(resourceDetailsDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTypeResources(@PathVariable Long id) {
        resourceDetailsService.deleteResourceDetails(id);
    }
}

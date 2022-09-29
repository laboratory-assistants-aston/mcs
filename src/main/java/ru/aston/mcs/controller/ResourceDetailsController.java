package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dao.ResourceDetailsService;
import ru.aston.mcs.entity.ResourceDetails;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resource-details")
public class ResourceDetailsController {

    public final ResourceDetailsService resourceDetailsService;

    public ResourceDetailsController(ResourceDetailsService resourceDetailsService) {
        this.resourceDetailsService = resourceDetailsService;
    }

    @GetMapping("/")
    public List<ResourceDetails> getAllTypeResources(){
        return  resourceDetailsService.getAllResourceDetails();
    }

    @GetMapping("/{id}")
    public ResourceDetails getTypeResources(@PathVariable int id){
        return resourceDetailsService.getResourceDetails(id);
    }

    @PostMapping("/")
    public ResourceDetails addTypeResources(@RequestBody ResourceDetails resourceDetails){
        resourceDetailsService.saveResourceDetails(resourceDetails);
        return resourceDetails;
    }

    @PutMapping("/")
    public ResourceDetails updateTypeResources(@RequestBody ResourceDetails resourceDetails){
        resourceDetailsService.saveResourceDetails(resourceDetails);
        return resourceDetails;
    }

    @DeleteMapping("/{id}")
    public String deleteTypeResources(@PathVariable int id){
        resourceDetailsService.deleteResourceDetails(id);
        return "ResourceDetails" + id + "was deleted";
    }
}

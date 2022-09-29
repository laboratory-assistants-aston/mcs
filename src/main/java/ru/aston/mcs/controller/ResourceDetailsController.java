package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.service.ResourceDetailsService;
import ru.aston.mcs.dto.ResourceDetailsDTO;
import ru.aston.mcs.entity.ResourceDetails;
import ru.aston.mcs.mappers.ResourceDetailsListMapper;
import ru.aston.mcs.mappers.ResourceDetailsMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resource-details")
public class ResourceDetailsController {

    public final ResourceDetailsService resourceDetailsService;
    public final ResourceDetailsListMapper resourceDetailsListMapper;
    public final ResourceDetailsMapper resourceDetailsMapper;


    public ResourceDetailsController(ResourceDetailsListMapper resourceDetailsListMapper, ResourceDetailsMapper resourceDetailsMapper, ResourceDetailsService resourceDetailsService) {
        this.resourceDetailsService = resourceDetailsService;
        this.resourceDetailsListMapper = resourceDetailsListMapper;
        this.resourceDetailsMapper = resourceDetailsMapper;
    }

    @GetMapping("/")
    public List<ResourceDetailsDTO> getAllTypeResources(){

        List<ResourceDetails> allResourceDetails = resourceDetailsService.getAllResourceDetails();

        return  resourceDetailsListMapper.toDTOList(allResourceDetails);
    }

    @GetMapping("/{id}")
    public ResourceDetailsDTO getTypeResources(@PathVariable int id){

        ResourceDetails resourceDetails = resourceDetailsService.getResourceDetails(id);

        return resourceDetailsMapper.toDTO(resourceDetails);
    }

    @PostMapping("/")
    public ResourceDetailsDTO addTypeResources(@RequestBody ResourceDetailsDTO resourceDetailsDTO){
        ResourceDetails resourceDetails = resourceDetailsMapper.toModel(resourceDetailsDTO);
        resourceDetailsService.saveResourceDetails(resourceDetails);
        return resourceDetailsDTO;
    }

    @PutMapping("/")
    public ResourceDetailsDTO updateTypeResources(@RequestBody ResourceDetailsDTO resourceDetailsDTO){
        ResourceDetails resourceDetails = resourceDetailsMapper.toModel(resourceDetailsDTO);
        resourceDetailsService.saveResourceDetails(resourceDetails);
        return resourceDetailsDTO;
    }

    @DeleteMapping("/{id}")
    public String deleteTypeResources(@PathVariable int id){
        resourceDetailsService.deleteResourceDetails(id);
        return "ResourceDetails" + id + "was deleted";
    }
}

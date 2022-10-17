package ru.aston.mcs.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.ResourceDTO;
import ru.aston.mcs.service.ResourceService;

import java.util.List;

@RestController
@RequestMapping("api/resources")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @ApiOperation(value = "Get all resources", notes = "Get all resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "all type resources founded")})
    @GetMapping("/")
    public List<ResourceDTO> getAllResources() {
        return resourceService.getAllResource();
    }

    @ApiOperation(value = "Get resources by id", notes = "Gets current resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources founded")})
    @GetMapping("/{id}")
    public ResourceDTO getResources(@PathVariable Long id) {
        return resourceService.getResource(id);
    }

    @ApiOperation(value = "Create new resources", notes = "Creates new resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "New type resources created")})
    @PostMapping("/")
    public ResourceDTO addResources(@RequestBody ResourceDTO ResourcesDto) {
        return resourceService.create(ResourcesDto);
    }

    @ApiOperation(value = "Update resources by id", notes = "Updates current resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources updated")})
    @PutMapping("/{id}")
    public ResourceDTO updateResources(@PathVariable Long id, @RequestBody ResourceDTO ResourcesDto) {
        return resourceService.updateResource(id, ResourcesDto);
    }

    @ApiOperation(value = "Delete resources by id", notes = "Deletes current resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources deleted")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResources(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return ResponseEntity.ok().build();
    }
}

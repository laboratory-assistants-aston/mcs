package ru.aston.mcs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(basePath = "/api/resource-types", value = "resource-types", description = "CRUD-Operations with resource-types table", produces = "application/json")
public class ResourceTypeController {

    private final ResourceTypeService typeResourcesService;

    public ResourceTypeController(ResourceTypeService typeResourcesService) {
        this.typeResourcesService = typeResourcesService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Get all type resources by Id", notes = "Get all type of resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "all type resources founded") })
    public List<ResourceTypeDTO> getAllTypeResources() {

        return typeResourcesService.getAllResourceTypes();

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get type resources by id", notes = "Gets current type of resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources founded") })
    public ResourceTypeDTO getTypeResources(@PathVariable Long id) {

        return typeResourcesService.getResourceType(id);
    }

    @PostMapping("/")
    @ApiOperation(value = "Create new type resources", notes = "Creates new type of resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "New type resources created") })
    public ResourceTypeDTO createTypeResources(@RequestBody ResourceTypeDTO typeResourcesDto) {

        return typeResourcesService.createResourceType(typeResourcesDto);
    }

    @PutMapping("/")
    @ApiOperation(value = "Update type resources by id", notes = "Updates current type of resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources updated") })
    public ResourceTypeDTO updateTypeResources(@PathVariable Long resourceTypeId, @RequestBody ResourceTypeDTO typeResourcesDto) {

        return typeResourcesService.updateResourceType(resourceTypeId, typeResourcesDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete type resources by id", notes = "Deletes current type of resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources deleted") })
    public void deleteTypeResources(@PathVariable Long id) {

        typeResourcesService.deleteResourceType(id);
    }
}
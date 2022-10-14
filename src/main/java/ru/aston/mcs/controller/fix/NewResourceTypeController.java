package ru.aston.mcs.controller.fix;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.mcs.dto.request.ResourceTypeRequest;
import ru.aston.mcs.dto.response.ResourceTypeResponse;
import ru.aston.mcs.service.fix.IResourceTypeService;

import java.util.List;

@Api(basePath = "api/v2/resource-type", value = "resource-types", description = "CRUD-Operations with resource-types table", produces = "application/json")
@RestController
@RequestMapping("api/v2/resource-type")
public class NewResourceTypeController {

    private final IResourceTypeService resourceTypeService;

    public NewResourceTypeController(IResourceTypeService resourceTypeService) {
        this.resourceTypeService = resourceTypeService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Get all type resources by Id", notes = "Get all type of resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "all type resources founded") })
    public List<ResourceTypeResponse> getAllTypeResources() {

        return resourceTypeService.getAll();

    }


    @ApiOperation(value = "Get type resources by id", notes = "Gets current type of resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources founded") })
    @GetMapping("/{id}")
    public ResourceTypeResponse getTypeResources(@PathVariable Long id) {

        return resourceTypeService.get(id);
    }

    @PostMapping("/")
    @ApiOperation(value = "Create new type resources", notes = "Creates new type of resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "New type resources created") })
    public ResourceTypeResponse createTypeResources(@RequestBody ResourceTypeRequest resourceTypeRequest) {

        return resourceTypeService.create(resourceTypeRequest);
    }


    @ApiOperation(value = "Update type resources by id", notes = "Updates current type of resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources updated") })
    @PutMapping("/{id}")
    public ResourceTypeResponse updateTypeResources(@PathVariable Long id, @RequestBody ResourceTypeRequest resourceTypeRequest) {
        return resourceTypeService.update(id, resourceTypeRequest);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete type resources by id", notes = "Deletes current type of resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources deleted") })
    public void deleteTypeResources(@PathVariable Long id) {

        resourceTypeService.delete(id);
    }
}

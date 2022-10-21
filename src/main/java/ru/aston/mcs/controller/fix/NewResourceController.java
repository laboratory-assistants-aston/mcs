package ru.aston.mcs.controller.fix;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.mcs.dto.request.ResourceRequest;
import ru.aston.mcs.dto.response.ResourceResponse;
import ru.aston.mcs.service.fix.IResourceService;

import java.util.List;

@Api(basePath = "api/v2/resources", value = "resources", description = "Operations with resources", produces = "application/json")
@RestController
@RequestMapping("api/v2/resources")
public class NewResourceController {

    private final IResourceService resourceService;

    public NewResourceController(IResourceService resourceService) {
        this.resourceService = resourceService;
    }


    @ApiOperation(value = "Get all resources", notes = "Get all resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "all type resources founded")})
    @GetMapping("/")
    public List<ResourceResponse> getAllResources() {
        return resourceService.getAll();
    }

    @ApiOperation(value = "Get resources by id", notes = "Gets current resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources founded")})
    @GetMapping("/{id}")
    public ResourceResponse getResources(@PathVariable Long id) {
        return resourceService.get(id);
    }

    @ApiOperation(value = "Create new resources", notes = "Creates new resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "New type resources created")})
    @PostMapping("/")
    public ResourceResponse addResources(@RequestBody ResourceRequest resourceRequest) {
        return resourceService.create(resourceRequest);
    }

    @ApiOperation(value = "Update resources by id", notes = "Updates current resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources updated")})
    @PutMapping("/{id}")
    public ResourceResponse updateResources(@PathVariable Long id, @RequestBody ResourceRequest resourceRequest) {
        return resourceService.update(id, resourceRequest);
    }

    @ApiOperation(value = "Delete resources by id", notes = "Deletes current resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources deleted")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResources(@PathVariable Long id) {
        resourceService.delete(id);
        return ResponseEntity.ok().build();
    }

}

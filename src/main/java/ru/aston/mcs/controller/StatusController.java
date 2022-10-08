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
import ru.aston.mcs.dto.StatusDTO;
import ru.aston.mcs.service.StatusService;
import java.util.List;

@RestController
@RequestMapping("/api/status")
@Api(basePath = "/api/status", value = "status", description = "CRUD-Operations with status table", produces = "application/json")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Get all status by Id", notes = "Get all status by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "All status founded") })
    public List<StatusDTO> getAllStatus() {
        return statusService.getAllStatus();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get status by Id", notes = "Gets status by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Status founded") })
    public StatusDTO getStatus(@PathVariable Long id) {
        return statusService.getStatus(id);
    }

    @PostMapping("/")
    @ApiOperation(value = "Create new status", notes = "Creates new status by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "New status created") })
    public StatusDTO createStatus(@RequestBody StatusDTO statusDTO) {
        return statusService.createStatus(statusDTO);
    }

    @PutMapping("/")
    @ApiOperation(value = "Update status by id", notes = "Updates current status by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Status updated") })
    public StatusDTO updateStatus(@PathVariable Long id, @RequestBody StatusDTO statusDTO) {
        return statusService.updateStatus(id, statusDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete status by id", notes = "Deletes current status by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Status deleted") })
    public void deleteStatus(@PathVariable Long id) {
        statusService.deleteStatus(id);
    }
}
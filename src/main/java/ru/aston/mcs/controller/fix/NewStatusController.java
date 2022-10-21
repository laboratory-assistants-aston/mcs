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
import ru.aston.mcs.dto.request.StatusRequest;
import ru.aston.mcs.dto.response.StatusResponse;
import ru.aston.mcs.service.fix.IStatusService;

import java.util.List;

@Api(basePath = "api/v2/status", value = "status", description = "CRUD-Operations with status table", produces = "application/json")
@RestController
@RequestMapping("api/v2/status")
public class NewStatusController {

    private final IStatusService statusService;

    public NewStatusController(IStatusService statusService) {
        this.statusService = statusService;
    }

    @ApiOperation(value = "Get all status by Id", notes = "Get all status by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "All status founded") })
    @GetMapping("/")
    public List<StatusResponse> getAllStatus() {
        return statusService.getAll();
    }


    @ApiOperation(value = "Get status by Id", notes = "Gets status by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Status founded") })
    @GetMapping("/{id}")
    public StatusResponse getStatus(@PathVariable Long id) {
        return statusService.get(id);
    }


    @ApiOperation(value = "Create new status", notes = "Creates new status by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "New status created") })
    @PostMapping("/")
    public StatusResponse createStatus(@RequestBody StatusRequest statusRequest) {
        return statusService.create(statusRequest);
    }


    @ApiOperation(value = "Update status by id", notes = "Updates current status by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Status updated") })
    @PutMapping("/{id}")
    public StatusResponse updateStatus(@PathVariable Long id, @RequestBody StatusRequest statusRequest) {
        return statusService.update(id, statusRequest);
    }


    @ApiOperation(value = "Delete status by id", notes = "Deletes current status by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Status deleted") })
    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Long id) {
        statusService.delete(id);
    }
}

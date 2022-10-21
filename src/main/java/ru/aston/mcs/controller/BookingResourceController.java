package ru.aston.mcs.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.BookingResourceDTO;
import ru.aston.mcs.dto.ResponseBookingResourceDTO;
import ru.aston.mcs.service.BookingResourceServices;

import java.util.List;

@RestController
@RequestMapping("/api/resource-booking")
public class BookingResourceController {
    private final BookingResourceServices resourcesServices;

    public BookingResourceController(BookingResourceServices resourcesServices) {
        this.resourcesServices = resourcesServices;
    }

    @ApiOperation(value = "Get all booking resources", notes = "Get all booking resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "all type resources founded")})
    @GetMapping("/")
    public List<BookingResourceDTO> getAllTypeResources() {
        return resourcesServices.getAllBookingResources();
    }

    @ApiOperation(value = "Get booking resources by id", notes = "Gets current booking resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources founded")})
    @GetMapping("/{id}")
    public BookingResourceDTO getUser(@PathVariable Long id) {
        return resourcesServices.getBookingResource(id);
    }

    @ApiOperation(value = "Create new booking resources", notes = "Creates new booking resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "New type resources created")})
    @PostMapping("/")
    public BookingResourceDTO saveUser(@RequestBody BookingResourceDTO resourcesDto) {
        return resourcesServices.createBookingResource(resourcesDto);
    }


    @ApiOperation(value = "Update booking resources by id", notes = "Updates current booking resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources updated")})
    @PutMapping("/{id}")
    public BookingResourceDTO updateUser(@PathVariable Long id, @RequestBody BookingResourceDTO resourceDto) {
        return resourcesServices.updateBookingResource(id, resourceDto);
    }

    @ApiOperation(value = "Delete booking resources by id", notes = "Deletes current booking resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources deleted")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        resourcesServices.deleteBookingResource(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Get all bookings for user", notes = "Get all bookings for user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Return is successful")})
    @GetMapping("/list")
    public List<ResponseBookingResourceDTO> getAllBookingsForUser(@RequestParam Long id) {
        return resourcesServices.findAllBookingsByUserId(id);
    }

    @ApiOperation(value = "Test", notes = "Test")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Test")})
    @GetMapping("/list2")
    public List<BookingResourceDTO> getAllBookingsForUserTest(@RequestParam Long id) {
        return resourcesServices.findAllBookingsByUserIdTest(id);
    }

    @ApiOperation(value = "Cancel booking for user", notes = "Cancel booking for user by BookingId")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Cancel is successful")})
    @PatchMapping("/list/{id}")
    public void cancelBookingById(@PathVariable Long id) {
        resourcesServices.cancelBookingById(id);
    }
}

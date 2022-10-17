package ru.aston.mcs.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.BookingResourceRequestDTO;
import ru.aston.mcs.dto.BookingResourceResponseDTO;
import ru.aston.mcs.entity.Resource;
import ru.aston.mcs.entity.Status;
import ru.aston.mcs.entity.User;
import ru.aston.mcs.mapper.BookingResourceMapper;
import ru.aston.mcs.service.BookingResourceOperationService;
import ru.aston.mcs.service.BookingResourceServices;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/resource-booking")
public class BookingResourceController {
    private final BookingResourceServices resourcesServices;

    @Autowired
    private BookingResourceOperationService bookingResourceOperationService;

    public BookingResourceController(BookingResourceServices resourcesServices) {
        this.resourcesServices = resourcesServices;
    }

    @ApiOperation(value = "Get all booking resources", notes = "Get all booking resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "all type resources founded")})
    @GetMapping("/")
    public List<BookingResourceResponseDTO> getAllTypeResources() {
        return resourcesServices.getAllBookingResources();
    }

    @ApiOperation(value = "Get booking resources by id", notes = "Gets current booking resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources founded")})
    @GetMapping("/{id}")
    public BookingResourceResponseDTO getBookingResource (@PathVariable Long id) {
        return resourcesServices.getBookingResource(id);
    }

    @ApiOperation(value = "Create new booking resources", notes = "Creates new booking resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "New type resources created")})
    @PostMapping("/")
    public BookingResourceResponseDTO saveBookingResource(@RequestBody BookingResourceResponseDTO resourcesDto) {
        return resourcesServices.createBookingResource(resourcesDto);
    }


    @ApiOperation(value = "Update booking resources by id", notes = "Updates current booking resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources updated")})
    @PutMapping("/{id}")
    public BookingResourceResponseDTO updateBookingResource(@PathVariable Long id, @RequestBody BookingResourceResponseDTO resourceDto) {
        return resourcesServices.updateBookingResource(id, resourceDto);
    }

    @ApiOperation(value = "Delete booking resources by id", notes = "Deletes current booking resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources deleted")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingResource(@PathVariable Long id) {
        resourcesServices.deleteBookingResource(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/free-resources/{resourceId}")
    public String bookFreeResource(@RequestBody BookingResourceRequestDTO bookingResourceRequestDTO,
                                                       @PathVariable Long resourceId){
        System.out.println(bookingResourceRequestDTO);
        bookingResourceOperationService.bookFreeResource(bookingResourceRequestDTO,
                                                            resourceId);
        return "Resource is booked successfully";
    }

    @GetMapping("/chtonibud")
    public BookingResourceResponseDTO getBookingResource () {
        return new BookingResourceResponseDTO(1L, new Resource(), new Status(),
                1, new Date(), new Date(), new User());
    }
}

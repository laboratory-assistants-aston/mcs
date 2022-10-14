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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.mcs.dto.query.SearchResourceForBook;
import ru.aston.mcs.dto.query.SearchResourceForBookByStartAndEnd;
import ru.aston.mcs.dto.request.BookingResourceRequest;
import ru.aston.mcs.dto.request.ResourceRequest;
import ru.aston.mcs.dto.response.BookingResourceResponse;
import ru.aston.mcs.dto.response.ResourceResponse;
import ru.aston.mcs.service.BookingResourceOperationService;
import ru.aston.mcs.service.fix.IBookingResourceService;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Api(basePath = "api/v2/booking", value = "booking", description = "Operations with booking", produces = "application/json")
@RestController
@RequestMapping("api/v2/booking")
public class NewBookingResourceController {

    private final IBookingResourceService bookingResourceService;
    private final BookingResourceOperationService bookingResourceOperationService;

    public NewBookingResourceController(IBookingResourceService bookingResourceService, BookingResourceOperationService bookingResourceOperationService) {
        this.bookingResourceService = bookingResourceService;
        this.bookingResourceOperationService = bookingResourceOperationService;
    }

    @ApiOperation(value = "Get all booking resources", notes = "Get all booking resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "all type resources founded")})
    @GetMapping("/")
    public List<BookingResourceResponse> getAllBookingResource() {
        return bookingResourceService.getAll();
    }

    @ApiOperation(value = "Get booking resources by id", notes = "Gets current booking resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources founded")})
    @GetMapping("/{id}")
    public BookingResourceResponse getBookingResource(@PathVariable Long id) {
        return bookingResourceService.get(id);
    }

    @ApiOperation(value = "Create new booking resources", notes = "Creates new booking resource")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "New type resources created")})
    @PostMapping("/")
    public BookingResourceResponse createBookingResource(@RequestBody BookingResourceRequest bookingResourceRequest) {
        return bookingResourceService.create(bookingResourceRequest);
    }

    @ApiOperation(value = "Update booking resources by id", notes = "Updates current booking resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources updated")})
    @PutMapping("/{id}")
    public BookingResourceResponse updateBookingResource(@PathVariable Long id, @RequestBody BookingResourceRequest bookingResourceRequest) {
        return bookingResourceService.update(id, bookingResourceRequest);
    }

    @ApiOperation(value = "Delete booking resources by id", notes = "Deletes current booking resource by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources deleted")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingResource(@PathVariable Long id) {
        bookingResourceService.delete(id);
        return ResponseEntity.ok().build();
    }


    @ApiOperation(value = "Search free resources for booking", notes = "Search free resources for booking")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources deleted")})
    @PostMapping("/free-resources-by-day")
    public List<ResourceResponse> freeResourcesForCurrentDay(@RequestBody SearchResourceForBook searchResourceForBook) {

       Long resourceTypeId =  searchResourceForBook.getResourceTypeId();
       LocalDate startDate =  searchResourceForBook.getStartDate();
       LocalTime startTime =  searchResourceForBook.getStartTime();
       Integer durationTime =  searchResourceForBook.getDurationTime();

        //Получить список ресурсов по типу ресурсов, для которых отсутствует активная бронь
        //Отправить список клиенту

        return bookingResourceOperationService.getAllFreeResourcesByStartAndByDuration(resourceTypeId, startDate, startTime, durationTime);
    }


    @ApiOperation(value = "Search free resources for booking", notes = "Search free resources for booking")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Type resources deleted")})
    @PostMapping("/free-resources")
    public List<ResourceResponse> freeResourcesForStartDayAndEndDay(@RequestBody SearchResourceForBookByStartAndEnd searchResourceForBookByStartAndEnd) {

        Long resourceTypeId =  searchResourceForBookByStartAndEnd.getResourceTypeId();
        LocalDate startDate =  searchResourceForBookByStartAndEnd.getStartDate();
        LocalTime startTime =  searchResourceForBookByStartAndEnd.getStartTime();
        LocalDate endDate =  searchResourceForBookByStartAndEnd.getEndDate();
        LocalTime endTime =  searchResourceForBookByStartAndEnd.getEndTime();
        //Получить список ресурсов по типу ресурсов, для которых отсутствует активная бронь
        //Отправить список клиенту

        return bookingResourceOperationService.getAllFreeResourcesByStartBookingAndByEndBooking(resourceTypeId, startDate, startTime,endDate, endTime);
    }
}

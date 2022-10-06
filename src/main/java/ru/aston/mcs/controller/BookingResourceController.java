package ru.aston.mcs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.BookingResourceDTO;
import ru.aston.mcs.service.BookingResourceServices;

import java.util.List;

@RestController
@RequestMapping("/api/resource-booking")
public class BookingResourceController {
    private final BookingResourceServices resourcesServices;

    public BookingResourceController(BookingResourceServices resourcesServices) {
        this.resourcesServices = resourcesServices;
    }

    @GetMapping("/")
    public List<BookingResourceDTO> getAllTypeResources() {
        return resourcesServices.getAllBookingResources();
    }

    @GetMapping("/{id}")
    public BookingResourceDTO getUser(@PathVariable Long id) {
        return resourcesServices.getBookingResource(id);
    }

    @PostMapping("/")
    public ResponseEntity<Void> saveUser(@RequestBody BookingResourceDTO resourcesDto) {
        resourcesServices.addAndSaveBookingResource(resourcesDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateUser(@RequestBody BookingResourceDTO resourceDto) {
        resourcesServices.addAndSaveBookingResource(resourceDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        resourcesServices.deleteBookingResource(id);
        return ResponseEntity.ok().build();
    }
}

package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.BookingResourceDTO;
import ru.aston.mcs.service.BookingResourceServices;

import java.util.List;

@RestController
@RequestMapping("/api/resource-booking")
public class ResourceBookingController {
    private final BookingResourceServices resourcesServices;

    public ResourceBookingController(BookingResourceServices resourcesServices) {
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
    public void saveUser(@RequestBody BookingResourceDTO resourcesDto) {
        resourcesServices.addAndSaveBookingResource(resourcesDto);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody BookingResourceDTO resourceDto) {
        resourcesServices.addAndSaveBookingResource(resourceDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        resourcesServices.deleteBookingResource(id);
    }
}

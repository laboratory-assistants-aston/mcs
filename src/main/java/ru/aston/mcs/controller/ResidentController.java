package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.ResidentDTO;
import ru.aston.mcs.service.ResidentService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class ResidentController {

    public final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping("/")
    public List<ResidentDTO> getAllUsers() {
        return residentService.getAllResident();
    }

    @GetMapping("/{id}")
    public ResidentDTO getUser(@PathVariable Long id) {
        return residentService.getResident(id);
    }

    @PostMapping("/")
    public void saveUser(@RequestBody ResidentDTO residentDto) {
        residentService.createResident(residentDto);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody ResidentDTO residentDto) {
        residentService.createResident(residentDto);
    }

    @DeleteMapping("/")
    public void deleteUser(@PathVariable Long id) {
        residentService.deleteResident(id);
    }
}

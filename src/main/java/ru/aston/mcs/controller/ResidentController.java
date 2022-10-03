package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.ResidentDTO;
import ru.aston.mcs.service.ResidentService;

import java.util.List;

@RestController
@RequestMapping("/api/residents")
public class ResidentController {

    public final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping("/")
    public List<ResidentDTO> getAllResidents() {
        return residentService.getAllResident();
    }

    @GetMapping("/{id}")
    public ResidentDTO getResident(@PathVariable Long id) {
        return residentService.getResident(id);
    }

    @PostMapping("/")
    public void saveResident(@RequestBody ResidentDTO residentDto) {
        residentService.createResident(residentDto);
    }

    @PutMapping("/")
    public void updateResident(@RequestBody ResidentDTO residentDto) {
        residentService.createResident(residentDto);
    }

    @DeleteMapping("/")
    public void deleteResident(@PathVariable Long id) {
        residentService.deleteResident(id);
    }
}

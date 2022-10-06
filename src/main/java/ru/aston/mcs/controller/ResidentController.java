package ru.aston.mcs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Void> saveResident(@RequestBody ResidentDTO residentDto) {
        residentService.createResident(residentDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateResident(@RequestBody ResidentDTO residentDto) {
        residentService.createResident(residentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResident(@PathVariable Long id) {
        residentService.deleteResident(id);
        return ResponseEntity.ok().build();
    }
}

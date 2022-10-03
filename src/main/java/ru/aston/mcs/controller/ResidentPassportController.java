package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.ResidentPassportDTO;
import ru.aston.mcs.service.ResidentPassportService;

import java.util.List;

@RestController
@RequestMapping("/api/residents-passport-data")
public class ResidentPassportController {

    public final ResidentPassportService residentPassportService;

    public ResidentPassportController(ResidentPassportService residentPassportService) {
        this.residentPassportService = residentPassportService;
    }

    @GetMapping("/")
    public List<ResidentPassportDTO> getAllUserPassportDatas() {
        return residentPassportService.getAllUserPassportDatas();
    }

    @GetMapping("/{id}")
    public ResidentPassportDTO getUserPassportData(@PathVariable Long id) {
        return residentPassportService.getUserPassportData(String.valueOf(id));
    }

    @PostMapping("/")
    public void addNewUserPassportData(@RequestBody ResidentPassportDTO residentPassportDTO) {
        residentPassportService.addAndSaveUserPassportData(residentPassportDTO);
    }

    @PutMapping("/")
    public void updateUserPassportData(@RequestBody ResidentPassportDTO residentPassportDTO) {
        residentPassportService.addAndSaveUserPassportData(residentPassportDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUserPassportData(@PathVariable Long id) {
        residentPassportService.deleteUserPassportData(String.valueOf(id));
    }
}

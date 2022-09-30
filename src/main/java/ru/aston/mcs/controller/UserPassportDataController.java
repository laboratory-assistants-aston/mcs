package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.UserPassportDataDTO;
import ru.aston.mcs.service.UserPassportDataService;

import java.util.List;

@RestController
@RequestMapping("/api/user-passport-datas")
public class UserPassportDataController {

    public final UserPassportDataService userPassportDataService;

    public UserPassportDataController(UserPassportDataService userPassportDataService) {
        this.userPassportDataService = userPassportDataService;
    }

    @GetMapping("/")
    public List<UserPassportDataDTO> getAllUserPassportDatas() {

        return userPassportDataService.getAllUserPassportDatas();
    }

    @GetMapping("/{id}")
    public UserPassportDataDTO getUserPassportData(@PathVariable Long id) {

        return userPassportDataService.getUserPassportData(String.valueOf(id));
    }

    @PostMapping("/")
    public void addNewUserPassportData(@RequestBody UserPassportDataDTO userPassportDataDTO) {

        userPassportDataService.addAndSaveUserPassportData(userPassportDataDTO);
    }

    @PutMapping("/")
    public void updateUserPassportData(@RequestBody UserPassportDataDTO userPassportDataDTO) {
        userPassportDataService.addAndSaveUserPassportData(userPassportDataDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUserPassportData(@PathVariable Long id) {

        userPassportDataService.deleteUserPassportData(String.valueOf(id));
    }
}

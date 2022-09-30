package ru.aston.mcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.UserPassportDataDTO;
import ru.aston.mcs.entity.ResourceDetails;
import ru.aston.mcs.entity.UserPassportData;
import ru.aston.mcs.mapper.UserPassportDataMapper;
import ru.aston.mcs.service.UserPassportDataService;

import java.util.List;

@RestController
@RequestMapping("/api/userpassportdatas")
public class UserPassportDataController {

    public UserPassportDataService userPassportDataService;
    public UserPassportDataMapper userPassportDataMapper;

    public UserPassportDataController(UserPassportDataService userPassportDataService, UserPassportDataMapper userPassportDataMapper) {
        this.userPassportDataService = userPassportDataService;
        this.userPassportDataMapper = userPassportDataMapper;
    }

    @GetMapping("/")
    public List<UserPassportData> showAllUserPassportDatas(){

        List<UserPassportData> allUserPassportDatas = userPassportDataService.getAllUserPassportDatas();

        return allUserPassportDatas;
    }

    @GetMapping("/{id}")
    public UserPassportDataDTO getUserPassportData(@PathVariable int id){

        UserPassportData userPassportData = userPassportDataService.getUserPassportData(String.valueOf(id));

        return userPassportDataMapper.userPassportDataInUserPassportDataDTO(userPassportData);
    }

    @PostMapping("/")
    public UserPassportDataDTO addNewUserPassportData(@RequestBody UserPassportDataDTO userPassportDataDTO){

        UserPassportData userPassportData = userPassportDataMapper.userPassportDataDtoInUserPassportData(userPassportDataDTO);
        userPassportDataService.saveUserPassportData(userPassportData);

        return userPassportDataDTO;
    }

    @PutMapping("/")
    public UserPassportDataDTO updateUserPassportData(@RequestBody UserPassportDataDTO userPassportDataDTO){

        UserPassportData userPassportData = userPassportDataMapper.userPassportDataDtoInUserPassportData(userPassportDataDTO);
        userPassportDataService.saveUserPassportData(userPassportData);

        return userPassportDataDTO;
    }

    @DeleteMapping("/{id}")
    public String deleteUserPassportData(@PathVariable int id){

        userPassportDataService.deleteUserPassportData(String.valueOf(id));

        return "UserPassportData " + id + " was deleted";
    }
}

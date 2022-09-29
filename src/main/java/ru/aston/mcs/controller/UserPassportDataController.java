package ru.aston.mcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.entity.UserPassportData;
import ru.aston.mcs.service.UserPassportDataService;

import java.util.List;

@RestController
@RequestMapping("/api/userpassportdatas")
public class UserPassportDataController {

    @Autowired
    private UserPassportDataService userPassportDataService;

    @GetMapping("/")
    public List<UserPassportData> showAllUserPassportDatas(){

        List<UserPassportData> allUserPassportDatas = userPassportDataService.getAllUserPassportDatas();

        return allUserPassportDatas;
    }

    @GetMapping("/{id}")
    public UserPassportData getUserPassportData(@PathVariable int id){

        UserPassportData userPassportData = userPassportDataService.getUserPassportData(String.valueOf(id));

        return userPassportData;
    }

    @PostMapping("/")
    public UserPassportData addNewUserPassportData(@RequestBody UserPassportData userPassportData){

        userPassportDataService.saveUserPassportData(userPassportData);

        return userPassportData;
    }

    @PutMapping("/")
    public UserPassportData updateUserPassportData(@RequestBody UserPassportData userPassportData){

        userPassportDataService.saveUserPassportData(userPassportData);

        return userPassportData;
    }

    @DeleteMapping("/{id}")
    public String deleteUserPassportData(@PathVariable int id){

        userPassportDataService.deleteUserPassportData(String.valueOf(id));

        return "UserPassportData " + id + "was deleted";
    }
}

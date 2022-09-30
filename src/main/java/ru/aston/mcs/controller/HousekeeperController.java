package ru.aston.mcs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.HousekeeperDTO;
import ru.aston.mcs.mapper.HousekeeperMapper;
import ru.aston.mcs.service.HousekeeperService;

import java.util.List;

@RestController
@RequestMapping("/api/housekeepers")
public class HousekeeperController {
    @Autowired
    private HousekeeperService housekeeperService;

    @Autowired
    private HousekeeperMapper housekeeperMapper;

    @GetMapping("/")
    public List<HousekeeperDTO> getAllHousekeepers() {
        return housekeeperMapper.listHousekeeperInHousekeeperDtoList(housekeeperService.getAllHousekeepers());
    }

    @GetMapping("/{id}")
    public HousekeeperDTO getHousekeeper(@PathVariable int id){
        return housekeeperMapper.housekeeperInHousekeeperDto(housekeeperService.getHousekeeper(id));
    }

    @PostMapping("/")
    public void addNewHousekeeper(@RequestBody HousekeeperDTO housekeeperDTO){
        housekeeperService.addAndSaveHousekeeper(housekeeperMapper.housekeeperDtoInHousekeeper(housekeeperDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteHousekeeper(@PathVariable int id){
        housekeeperService.deleteHousekeeper(id);
    }
}

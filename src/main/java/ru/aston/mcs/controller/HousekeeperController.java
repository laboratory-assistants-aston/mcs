package ru.aston.mcs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.entity.Housekeeper;
import ru.aston.mcs.service.HousekeeperService;

import java.util.List;

@RestController
@RequestMapping("/api/housekeepers")
public class HousekeeperController {
    @Autowired
    private HousekeeperService housekeeperService;

    @GetMapping("/")
    public List<Housekeeper> showAllHousekeepers(){
        return housekeeperService.getAllHousekeepers();
    }

    @GetMapping("/{id}")
    public Housekeeper getHousekeeper(@PathVariable int id){
        return housekeeperService.getHousekeeper(id);
    }

    @PostMapping("/")
    public Housekeeper addNewHousekeeper(@RequestBody Housekeeper housekeeper){
        housekeeperService.saveHousekeeper(housekeeper);
        return housekeeper;
    }

    @PutMapping("/")
    public Housekeeper updateHousekeeper(@RequestBody Housekeeper housekeeper){
        housekeeperService.saveHousekeeper(housekeeper);
        return housekeeper;
    }

    @DeleteMapping("/{id}")
    public String deleteHousekeeper(@PathVariable int id){
        housekeeperService.deleteHousekeeper(id);
        return "Housekeeper " + id + "was deleted";
    }
}

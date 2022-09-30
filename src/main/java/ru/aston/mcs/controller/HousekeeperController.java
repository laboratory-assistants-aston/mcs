package ru.aston.mcs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.HousekeeperDTO;
import ru.aston.mcs.service.HousekeeperService;

@RestController
@RequestMapping("/api/housekeepers")
public class HousekeeperController {
    @Autowired
    private HousekeeperService housekeeperService;

    @GetMapping("/{id}")
    public HousekeeperDTO getHousekeeper(@PathVariable Long id) {
        return housekeeperService.getHousekeeper(id);
    }

    @PostMapping("/")
    public void addNewHousekeeper(@RequestBody HousekeeperDTO housekeeperDTO) {
        housekeeperService.addAndSaveHousekeeper(housekeeperDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteHousekeeper(@PathVariable Long id) {
        housekeeperService.deleteHousekeeper(id);
    }
}

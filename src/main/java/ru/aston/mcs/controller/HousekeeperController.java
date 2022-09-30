package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.HousekeeperDTO;
import ru.aston.mcs.service.HousekeeperService;

import java.util.List;

@RestController
@RequestMapping("/api/housekeepers")
public class HousekeeperController {
    private final HousekeeperService housekeeperService;

    public HousekeeperController(HousekeeperService housekeeperService) {
        this.housekeeperService = housekeeperService;
    }


    @GetMapping("/")
    public List<HousekeeperDTO> getAllHousekeepers() {
        return housekeeperService.getAllHousekeepers();
    }

    @GetMapping("/{id}")
    public HousekeeperDTO getHousekeeper(@PathVariable Long id) {
        return housekeeperService.getHousekeeper(id);
    }

    @PostMapping("/")
    public void addNewHousekeeper(@RequestBody HousekeeperDTO housekeeperDTO) {
        housekeeperService.addAndSaveHousekeeper(housekeeperDTO);
    }


    @PutMapping("/")
    public void updateHousekeeper(@RequestBody HousekeeperDTO housekeeperDTO) {
        housekeeperService.addAndSaveHousekeeper(housekeeperDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteHousekeeper(@PathVariable Long id) {
        housekeeperService.deleteHousekeeper(id);
    }
}

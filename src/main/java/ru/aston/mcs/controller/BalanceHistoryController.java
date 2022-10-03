package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.BalanceHistoryDTO;
import ru.aston.mcs.service.BalanceHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/balance-histories")
public class BalanceHistoryController {

    private final BalanceHistoryService balanceHistoryService;

    public BalanceHistoryController(BalanceHistoryService balanceHistoryService) {
        this.balanceHistoryService = balanceHistoryService;
    }

    @GetMapping("/")
    public List<BalanceHistoryDTO> showAllBalanceHistories() {
        return balanceHistoryService.getAllBalanceHistories();
    }

    @GetMapping("/{id}")
    public BalanceHistoryDTO getBalanceHistory(@PathVariable Long id) {
        return balanceHistoryService.getBalanceHistory(id);
    }

    @PostMapping("/")
    public void addNewBalanceHistory(@RequestBody BalanceHistoryDTO balanceHistoryDTO) {
        balanceHistoryService.addAndSaveBalanceHistory(balanceHistoryDTO);
    }

    @PutMapping("/")
    public void updateBalanceHistory(@RequestBody BalanceHistoryDTO balanceHistoryDTO) {
        balanceHistoryService.addAndSaveBalanceHistory(balanceHistoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBalanceHistory(@PathVariable Long id) {
        balanceHistoryService.deleteBalanceHistory(id);
    }
}

package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.BalanceHistoryDTO;
import ru.aston.mcs.service.BalanceHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/balance_histories")
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

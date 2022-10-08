package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.TransactionHistoryDTO;
import ru.aston.mcs.service.TransactionHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-histories")
public class TransactionHistoryController {

    private final TransactionHistoryService transactionHistoryService;

    public TransactionHistoryController(TransactionHistoryService transactionHistoryService) {
        this.transactionHistoryService = transactionHistoryService;
    }

    @GetMapping("/")
    public List<TransactionHistoryDTO> getTransactionHistories() {
        return transactionHistoryService.getAllTransactionHistories();
    }

    @GetMapping("/{id}")
    public TransactionHistoryDTO getTransactionHistory(@PathVariable Long id) {
        return transactionHistoryService.getTransactionHistory(id);
    }

    @PostMapping("/")
    public void addNewTransactionHistory(@RequestBody TransactionHistoryDTO transactionHistoryDTO) {
        transactionHistoryService.addAndSaveTransactionHistory(transactionHistoryDTO);
    }

    @PutMapping("/")
    public void updateTransactionHistory(@RequestBody TransactionHistoryDTO transactionHistoryDTO) {
        transactionHistoryService.addAndSaveTransactionHistory(transactionHistoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTransactionHistory(@PathVariable Long id) {
        transactionHistoryService.deleteTransactionHistory(id);
    }
}

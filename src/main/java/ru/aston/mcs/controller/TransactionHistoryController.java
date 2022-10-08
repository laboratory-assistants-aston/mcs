package ru.aston.mcs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

@Api(basePath = "/api/transaction-histories", value = "transaction-histories", description = "Operations with transaction-histories", produces = "application/json")
@RestController
@RequestMapping("/api/transaction-histories")
public class TransactionHistoryController {

    private final TransactionHistoryService transactionHistoryService;

    public TransactionHistoryController(TransactionHistoryService transactionHistoryService) {
        this.transactionHistoryService = transactionHistoryService;
    }

    @ApiOperation(value = "Create new transaction history")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Transaction histories founded") })
    @GetMapping("/")
    public List<TransactionHistoryDTO> getTransactionHistories() {
        return transactionHistoryService.getAllTransactionHistories();
    }

    @ApiOperation(value = "Get new transaction history")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Transaction history founded") })
    @GetMapping("/{id}")
    public TransactionHistoryDTO getTransactionHistory(@PathVariable Long id) {
        return transactionHistoryService.getTransactionHistory(id);
    }

    @ApiOperation(value = "Add new transaction history")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Transaction history added") })
    @PostMapping("/")
    public TransactionHistoryDTO addNewTransactionHistory(@RequestBody TransactionHistoryDTO transactionHistoryDTO) {
        return transactionHistoryService.createTransactionHistory(transactionHistoryDTO);
    }

    @ApiOperation(value = "Update new transaction history")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Transaction history updated") })
    @PutMapping("/")
    public TransactionHistoryDTO updateTransactionHistory(@RequestBody TransactionHistoryDTO transactionHistoryDTO) {
        return transactionHistoryService.updateTransactionHistory(transactionHistoryDTO);
    }

    @ApiOperation(value = "Delete new transaction history")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Transaction history deleted") })
    @DeleteMapping("/{id}")
    public void deleteTransactionHistory(@PathVariable Long id) {
        transactionHistoryService.deleteTransactionHistory(id);
    }
}

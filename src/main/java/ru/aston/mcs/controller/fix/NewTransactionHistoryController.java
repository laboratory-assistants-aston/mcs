package ru.aston.mcs.controller.fix;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.mcs.dto.request.TransactionHistoryRequest;
import ru.aston.mcs.dto.response.TransactionHistoryResponse;
import ru.aston.mcs.service.fix.ITransactionHistoryService;
import java.util.List;

@Api(basePath = "api/v2/transaction-histories", value = "transaction-histories", description = "Operations with transaction-histories", produces = "application/json")
@RestController
@RequestMapping("api/v2/transaction-histories")
public class NewTransactionHistoryController {

    private final ITransactionHistoryService transactionHistoryService;

    public NewTransactionHistoryController(ITransactionHistoryService transactionHistoryService) {
        this.transactionHistoryService = transactionHistoryService;
    }

    @ApiOperation(value = "Create new transaction history")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Transaction histories founded") })
    @GetMapping("/")
    public List<TransactionHistoryResponse> getTransactionHistories() {
        return transactionHistoryService.getAll();
    }

    @ApiOperation(value = "Get new transaction history")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Transaction history founded") })
    @GetMapping("/{id}")
    public TransactionHistoryResponse getTransactionHistory(@PathVariable Long id) {
        return transactionHistoryService.get(id);
    }

    @ApiOperation(value = "Add new transaction history")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Transaction history added") })
    @PostMapping("/")
    public TransactionHistoryResponse createTransactionHistory(@RequestBody TransactionHistoryRequest transactionHistoryRequest) {
        return transactionHistoryService.create(transactionHistoryRequest);
    }

    @ApiOperation(value = "Update new transaction history")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Transaction history updated") })
    @PutMapping("/{id}")
    public TransactionHistoryResponse updateTransactionHistory(@PathVariable Long id, @RequestBody TransactionHistoryRequest transactionHistoryRequest) {
        return transactionHistoryService.update(id, transactionHistoryRequest);
    }

    @ApiOperation(value = "Delete new transaction history")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Transaction history deleted") })
    @DeleteMapping("/{id}")
    public void deleteTransactionHistory(@PathVariable Long id) {
        transactionHistoryService.delete(id);
    }
}

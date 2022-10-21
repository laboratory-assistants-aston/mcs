package ru.aston.mcs.dto.response;

import ru.aston.mcs.entity.User;
import ru.aston.mcs.entity.enums.Operation;

import java.util.Date;

public class TransactionHistoryResponse {

    private Long transaction_history_id;

    private User userId;

    private Double operationSum;

    private Operation operation;

    private String description;

    private Date modificationDate;

    public  TransactionHistoryResponse(){}

    public Long getTransaction_history_id() {
        return transaction_history_id;
    }

    public void setTransaction_history_id(Long transaction_history_id) {
        this.transaction_history_id = transaction_history_id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Double getOperationSum() {
        return operationSum;
    }

    public void setOperationSum(Double operationSum) {
        this.operationSum = operationSum;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}

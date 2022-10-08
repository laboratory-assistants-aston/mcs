package ru.aston.mcs.dto;

import ru.aston.mcs.entity.User;
import ru.aston.mcs.entity.enums.Operation;

import java.util.Date;

public class TransactionHistoryDTO {
    private Long id;
    private User userId;
    private Double operationSum;
    private Operation operation;
    private String description;
    private Date modificationDate;

    public TransactionHistoryDTO() {
    }

    public TransactionHistoryDTO(Long id, User userId, Double operationSum, Operation operation, String description, Date modificationDate) {
        this.id = id;
        this.userId = userId;
        this.operationSum = operationSum;
        this.operation = operation;
        this.description = description;
        this.modificationDate = modificationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

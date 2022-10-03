package ru.aston.mcs.dto;

import ru.aston.mcs.entity.Resident;
import ru.aston.mcs.entity.enums.Operation;

import java.util.Date;

public class BalanceHistoryDTO {
    private Long id;
    private Resident residentId;
    private Double operationSum;
    private Operation operation;
    private String description;
    private Date modificationDate;

    public BalanceHistoryDTO() {
    }

    public BalanceHistoryDTO(Long id, Resident residentId, Double operationSum, Operation operation, String description, Date modificationDate) {
        this.id = id;
        this.residentId = residentId;
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

    public Resident getResidentId() {
        return residentId;
    }

    public void setResidentId(Resident residentId) {
        this.residentId = residentId;
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

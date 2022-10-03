package ru.aston.mcs.entity;

import ru.aston.mcs.entity.enums.Operation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "balance_history")
public class BalanceHistory {

    @Id
    private Long id;

    @OneToOne(name = "resident_id")
    private Resident residentId;

    @Column(name = "operation_sum")
    private float operationSum;

    @Column(name = "operation")
    private Operation operation;

    @Column(name = "description")
    private String description;

    @Column(name = "modification_date")
    private Date modificationDate;

    public BalanceHistory() {
    }

    public BalanceHistory(Long id, Resident residentId,
                          float operationSum, Operation operation,
                          String descriprion, Date modificationDate) {
        this.id = id;
        this.residentId = residentId;
        this.operationSum = operationSum;
        this.operation = operation;
        this.description = descriprion;
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

    public float getOperationSum() {
        return operationSum;
    }

    public void setOperationSum(float operationSum) {
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

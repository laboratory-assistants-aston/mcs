package ru.aston.mcs.entity;

import ru.aston.mcs.entity.enums.Operation;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import java.util.Date;

@Entity
@Table(name = "balance_history")
public class BalanceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "balance_history_id")
    private Long balance_history_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id", nullable = false)
    private Resident residentId;

    @Column(name = "operation_sum", columnDefinition="Decimal(10,2) default '0.00'")
    private Double operationSum;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation", nullable = false)
    private Operation operation;

    @Column(name = "description")
    private String description;

    @Column(name = "modification_date", nullable = false)
    private Date modificationDate;

    public BalanceHistory() {
    }

    public BalanceHistory(Long id, Resident residentId,
                          Double operationSum, Operation operation,
                          String description, Date modificationDate) {
        this.balance_history_id = id;
        this.residentId = residentId;
        this.operationSum = operationSum;
        this.operation = operation;
        this.description = description;
        this.modificationDate = modificationDate;
    }

    public Long getBalance_history_id() {
        return balance_history_id;
    }

    public void setBalance_history_id(Long balance_history_id) {
        this.balance_history_id = balance_history_id;
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
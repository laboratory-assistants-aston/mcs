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
@Table(name = "transacton_history")
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_history_id")
    private Long transaction_history_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @Column(name = "operation_sum", columnDefinition="Decimal(10,2) default '0.00'")
    private Double operationSum;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation", nullable = false)
    private Operation operation;

    @Column(name = "description")
    private String description;

    @Column(name = "modification_date", nullable = false)
    private Date modificationDate;

    public TransactionHistory() {
    }

    public TransactionHistory(Long transaction_history_id, User userId, Double operationSum, Operation operation, String description, Date modificationDate) {
        this.transaction_history_id = transaction_history_id;
        this.userId = userId;
        this.operationSum = operationSum;
        this.operation = operation;
        this.description = description;
        this.modificationDate = modificationDate;
    }

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
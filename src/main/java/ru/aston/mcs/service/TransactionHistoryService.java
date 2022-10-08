package ru.aston.mcs.service;

import ru.aston.mcs.dto.TransactionHistoryDTO;

import java.util.List;

public interface TransactionHistoryService {
    List<TransactionHistoryDTO> getAllTransactionHistories();

    void addAndSaveTransactionHistory(TransactionHistoryDTO TransactionHistoryDTO);

    void deleteTransactionHistory(Long balanceHistoryId);

    TransactionHistoryDTO getTransactionHistory(Long balanceHistoryId);
}
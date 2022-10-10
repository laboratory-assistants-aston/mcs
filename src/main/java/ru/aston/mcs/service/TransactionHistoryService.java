package ru.aston.mcs.service;

import ru.aston.mcs.dto.TransactionHistoryDTO;

import java.util.List;

public interface TransactionHistoryService {
    List<TransactionHistoryDTO> getAllTransactionHistories();

    TransactionHistoryDTO createTransactionHistory(TransactionHistoryDTO TransactionHistoryDTO);

    TransactionHistoryDTO updateTransactionHistory(Long id, TransactionHistoryDTO TransactionHistoryDTO);

    void deleteTransactionHistory(Long balanceHistoryId);

    TransactionHistoryDTO getTransactionHistory(Long balanceHistoryId);
}
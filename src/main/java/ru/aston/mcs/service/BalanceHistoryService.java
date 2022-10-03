package ru.aston.mcs.service;

import ru.aston.mcs.dto.BalanceHistoryDTO;

import java.util.List;

public interface BalanceHistoryService {
    List<BalanceHistoryDTO> getAllBalanceHistories();

    void addAndSaveBalanceHistory(BalanceHistoryDTO BalanceHistoryDTO);

    void deleteBalanceHistory(Long balanceHistoryId);

    BalanceHistoryDTO getBalanceHistory(Long balanceHistoryId);
}

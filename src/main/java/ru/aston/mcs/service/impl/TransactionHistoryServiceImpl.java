package ru.aston.mcs.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.TransactionHistoryDTO;
import ru.aston.mcs.mapper.TransactionHistoryMapper;
import ru.aston.mcs.repository.TransactionHistoryRepository;
import ru.aston.mcs.service.TransactionHistoryService;

import java.util.List;

@Service
@Transactional
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    private final TransactionHistoryRepository transactionHistoryRepository;
    private final TransactionHistoryMapper transactionHistoryMapper;

    public TransactionHistoryServiceImpl(TransactionHistoryRepository transactionHistoryRepository, TransactionHistoryMapper transactionHistoryMapper) {
        this.transactionHistoryRepository = transactionHistoryRepository;
        this.transactionHistoryMapper = transactionHistoryMapper;
    }

    @Override
    public List<TransactionHistoryDTO> getAllTransactionHistories() {
        return transactionHistoryMapper.toDTOList(transactionHistoryRepository.findAll());
    }

    @Override
    public void addAndSaveTransactionHistory(TransactionHistoryDTO transactionHistoryDTO) {
        transactionHistoryRepository.save(
                transactionHistoryMapper.toModel(transactionHistoryDTO));
    }

    @Override
    public void deleteTransactionHistory(Long balanceHistoryId) {
        transactionHistoryRepository.deleteById(balanceHistoryId);
    }

    @Override
    public TransactionHistoryDTO getTransactionHistory(Long balanceHistoryId) {
        return transactionHistoryMapper.toDTO(
                transactionHistoryRepository.findById(balanceHistoryId)
                        .orElseThrow(RuntimeException::new));
    }
}
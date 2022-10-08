package ru.aston.mcs.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.TransactionHistoryDTO;
import ru.aston.mcs.entity.TransactionHistory;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.TransactionHistoryMapper;
import ru.aston.mcs.repository.TransactionHistoryRepository;
import ru.aston.mcs.service.TransactionHistoryService;

import javax.persistence.EntityNotFoundException;
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
    public TransactionHistoryDTO createTransactionHistory(TransactionHistoryDTO transactionHistoryDTO) {

        if (transactionHistoryDTO == null ) {
            throw new InvalidRequestException();
        }

        transactionHistoryRepository.save(transactionHistoryMapper.toModel(transactionHistoryDTO));
        return transactionHistoryDTO;
    }

    @Override
    public TransactionHistoryDTO updateTransactionHistory(TransactionHistoryDTO transactionHistoryDTO) {
        if (transactionHistoryDTO == null || transactionHistoryDTO.getId() == null) {
            throw new InvalidRequestException();
        }

        Long transactionHistoryId = transactionHistoryDTO.getId();
        TransactionHistory transactionHistoryFromDb = transactionHistoryRepository.findById(transactionHistoryId).orElseThrow(EntityNotFoundException::new);

        transactionHistoryFromDb.setDescription(transactionHistoryDTO.getDescription());
        transactionHistoryFromDb.setModificationDate(transactionHistoryDTO.getModificationDate());
        transactionHistoryFromDb.setOperation(transactionHistoryDTO.getOperation());
        transactionHistoryFromDb.setUserId(transactionHistoryDTO.getUserId());
        transactionHistoryFromDb.setOperationSum(transactionHistoryDTO.getOperationSum());

        return  transactionHistoryMapper.toDTO( transactionHistoryRepository.save(transactionHistoryFromDb));
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
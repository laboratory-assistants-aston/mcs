package ru.aston.mcs.service.fix;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.request.TransactionHistoryRequest;
import ru.aston.mcs.dto.response.TransactionHistoryResponse;
import ru.aston.mcs.entity.TransactionHistory;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.fix.NewTransactionHistoryMapper;
import ru.aston.mcs.repository.TransactionHistoryRepository;

import java.util.List;

@Service
@Transactional
public class NewTransactionHistoryServiceImpl implements ITransactionHistoryService{

    private final TransactionHistoryRepository transactionHistoryRepository;
    private final NewTransactionHistoryMapper newTransactionHistoryMapper;

    public NewTransactionHistoryServiceImpl(TransactionHistoryRepository transactionHistoryRepository, NewTransactionHistoryMapper newTransactionHistoryMapper) {
        this.transactionHistoryRepository = transactionHistoryRepository;
        this.newTransactionHistoryMapper = newTransactionHistoryMapper;
    }


    @Override
    public List<TransactionHistoryResponse> getAll() {
        return null;
    }

    @Override
    public TransactionHistoryResponse get(Long id) {
        return newTransactionHistoryMapper.toResponse(
                transactionHistoryRepository.findById(id)
                        .orElseThrow(RuntimeException::new));    }

    @Override
    public TransactionHistoryResponse create(TransactionHistoryRequest transactionHistoryRequest) {
        if (transactionHistoryRequest == null) {
            throw new InvalidRequestException();
        }
        return newTransactionHistoryMapper.toResponse(
                transactionHistoryRepository.save(
                        newTransactionHistoryMapper.toEntity(transactionHistoryRequest)));    }

    @Override
    public TransactionHistoryResponse update(Long id, TransactionHistoryRequest transactionHistoryRequest) {
        if (transactionHistoryRequest == null || id == null) {
            throw new InvalidRequestException();
        }
        TransactionHistory transactionHistoryFromDb =
                transactionHistoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        transactionHistoryFromDb.setOperation(transactionHistoryRequest.getOperation());
        transactionHistoryFromDb.setDescription(transactionHistoryRequest.getDescription());
        transactionHistoryFromDb.setModificationDate(transactionHistoryRequest.getModificationDate());
        transactionHistoryFromDb.setUserId(transactionHistoryRequest.getUserId());
        transactionHistoryFromDb.setOperationSum(transactionHistoryRequest.getOperationSum());

        return newTransactionHistoryMapper.toResponse(transactionHistoryRepository.save(transactionHistoryFromDb));
    }

    @Override
    public void delete(Long id) {

        transactionHistoryRepository.deleteById(id);
    }
}

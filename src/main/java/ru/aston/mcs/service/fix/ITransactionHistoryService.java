package ru.aston.mcs.service.fix;


import ru.aston.mcs.dto.request.TransactionHistoryRequest;
import ru.aston.mcs.dto.response.TransactionHistoryResponse;

import java.util.List;

public interface ITransactionHistoryService {

    List<TransactionHistoryResponse> getAll();

    TransactionHistoryResponse get(Long id);

    TransactionHistoryResponse create(TransactionHistoryRequest transactionHistoryRequest);

    TransactionHistoryResponse update(Long id, TransactionHistoryRequest transactionHistoryRequest);

    void delete(Long id);
}

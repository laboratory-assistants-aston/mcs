package ru.aston.mcs.mapper.fix;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.request.TransactionHistoryRequest;
import ru.aston.mcs.dto.response.TransactionHistoryResponse;
import ru.aston.mcs.entity.TransactionHistory;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewTransactionHistoryMapper {

    TransactionHistory  toEntity(TransactionHistoryRequest transactionHistoryRequest);

    TransactionHistoryResponse toResponse(TransactionHistory transactionHistory);

    List<TransactionHistoryResponse> toResponseList(List<TransactionHistory> transactionHistory);

}

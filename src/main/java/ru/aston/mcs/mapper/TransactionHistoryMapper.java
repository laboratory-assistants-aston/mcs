package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.TransactionHistoryDTO;
import ru.aston.mcs.entity.TransactionHistory;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionHistoryMapper {
    TransactionHistory toModel(TransactionHistoryDTO transactionHistoryDTO);

    TransactionHistoryDTO toDTO(TransactionHistory transactionHistory);

    List<TransactionHistory> toModelList(List<TransactionHistoryDTO> transactionHistoryDTOList);

    List<TransactionHistoryDTO> toDTOList(List<TransactionHistory> transactionHistoryList);
}
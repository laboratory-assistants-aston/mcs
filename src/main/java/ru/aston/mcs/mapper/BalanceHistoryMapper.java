package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.BalanceHistoryDTO;
import ru.aston.mcs.entity.BalanceHistory;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BalanceHistoryMapper {
    BalanceHistory toModel(BalanceHistoryDTO balanceHistoryDTO);

    BalanceHistoryDTO toDTO(BalanceHistory balanceHistory);

    List<BalanceHistory> toModelList(List<BalanceHistoryDTO> balanceHistoryDTOList);

    List<BalanceHistoryDTO> toDTOList(List<BalanceHistory> modelList);
}
package ru.aston.mcs.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.BalanceHistoryDTO;
import ru.aston.mcs.mapper.BalanceHistoryMapper;
import ru.aston.mcs.repository.BalanceHistoryRepository;
import ru.aston.mcs.service.BalanceHistoryService;

import java.util.List;

@Service
@Transactional
public class BalanceHistoryServiceImpl implements BalanceHistoryService {

    private final BalanceHistoryRepository balanceHistoryRepository;
    private final BalanceHistoryMapper balanceHistoryMapper;

    public BalanceHistoryServiceImpl(BalanceHistoryRepository balanceHistoryRepository, BalanceHistoryMapper balanceHistoryMapper) {
        this.balanceHistoryRepository = balanceHistoryRepository;
        this.balanceHistoryMapper = balanceHistoryMapper;
    }

    @Override
    public List<BalanceHistoryDTO> getAllBalanceHistories() {
        return balanceHistoryMapper.toDTOList(balanceHistoryRepository.findAll());
    }

    @Override
    public void addAndSaveBalanceHistory(BalanceHistoryDTO balanceHistoryDTO) {
        balanceHistoryRepository.save(
                balanceHistoryMapper.toModel(balanceHistoryDTO));
    }

    @Override
    public void deleteBalanceHistory(Long balanceHistoryId) {
        balanceHistoryRepository.deleteById(balanceHistoryId);
    }

    @Override
    public BalanceHistoryDTO getBalanceHistory(Long balanceHistoryId) {
        return balanceHistoryMapper.toDTO(
                balanceHistoryRepository.findById(balanceHistoryId)
                        .orElseThrow(RuntimeException::new));
    }
}
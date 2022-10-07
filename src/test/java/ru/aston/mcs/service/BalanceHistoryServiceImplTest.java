package ru.aston.mcs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.mcs.dto.BalanceHistoryDTO;
import ru.aston.mcs.entity.enums.Operation;
import ru.aston.mcs.mapper.BalanceHistoryMapper;
import ru.aston.mcs.repository.BalanceHistoryRepository;
import ru.aston.mcs.service.Impl.BalanceHistoryServiceImpl;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BalanceHistoryServiceImplTest {

    @Mock
    private BalanceHistoryRepository balanceHistoryRepository;
    @Mock
    private BalanceHistoryMapper balanceHistoryMapper;

    @InjectMocks
    private BalanceHistoryServiceImpl balanceHistoryService;

    private BalanceHistoryDTO balanceHistoryDTO;

    @BeforeEach
    void createDto() {
        balanceHistoryDTO = new BalanceHistoryDTO();
        balanceHistoryDTO.setDescription(null);
        balanceHistoryDTO.setOperation(Operation.DECREASE);
        balanceHistoryDTO.setModificationDate(new Date());
        balanceHistoryDTO.setResidentId(null);
    }

    @Test
    void getAllBalanceHistories() {
        balanceHistoryService.getAllBalanceHistories();
        Mockito.verify(balanceHistoryRepository).findAll();
    }

    @Test
    void getBalanceHistoryByIdTest() {
        RuntimeException runtimeException =
                assertThrows(RuntimeException.class, () -> balanceHistoryService.getBalanceHistory(1L));
        Mockito.verify(balanceHistoryRepository).findById(1L);
    }

    @Test
    void createBalanceHistoryFromDtoTest() {
        balanceHistoryService.addAndSaveBalanceHistory(balanceHistoryDTO);
        Mockito.verify(balanceHistoryRepository).save(balanceHistoryMapper.toModel(balanceHistoryDTO));
    }

    @Test
    void deleteBalanceHistoryByIdTest() {
        balanceHistoryService.deleteBalanceHistory(1L);
        Mockito.verify(balanceHistoryRepository).deleteById(1L);
    }
}
package ru.aston.mcs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Profile;
import ru.aston.mcs.dto.TransactionHistoryDTO;
import ru.aston.mcs.entity.enums.Operation;
import ru.aston.mcs.mapper.TransactionHistoryMapper;
import ru.aston.mcs.repository.TransactionHistoryRepository;
import ru.aston.mcs.service.impl.TransactionHistoryServiceImpl;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Profile("test")
class TransactionHistoryServiceImplTest {

    @Mock
    private TransactionHistoryRepository transactionHistoryRepository;
    @Mock
    private TransactionHistoryMapper transactionHistoryMapper;

    @InjectMocks
    private TransactionHistoryServiceImpl transactionHistoryService;

    private TransactionHistoryDTO transactionHistoryDTO;

    @BeforeEach
    void createDto() {
        transactionHistoryDTO = new TransactionHistoryDTO();
        transactionHistoryDTO.setDescription(null);
        transactionHistoryDTO.setOperation(Operation.DECREASE);
        transactionHistoryDTO.setModificationDate(new Date());
        transactionHistoryDTO.setUserId(null);
    }

    @Test
    void getAllTransactionHistories() {
        transactionHistoryService.getAllTransactionHistories();
        Mockito.verify(transactionHistoryRepository).findAll();
    }

    @Test
    void getTransactionHistoryByIdTest() {
        RuntimeException runtimeException =
                assertThrows(RuntimeException.class, () -> transactionHistoryService.getTransactionHistory(1L));
        Mockito.verify(transactionHistoryRepository).findById(1L);
    }

    @Test
    void createTransactionHistoryFromDtoTest() {
        transactionHistoryService.createTransactionHistory(transactionHistoryDTO);
        Mockito.verify(transactionHistoryRepository).save(transactionHistoryMapper.toModel(transactionHistoryDTO));
    }

    @Test
    void deleteTransactionHistoryByIdTest() {
        transactionHistoryService.deleteTransactionHistory(1L);
        Mockito.verify(transactionHistoryRepository).deleteById(1L);
    }
}
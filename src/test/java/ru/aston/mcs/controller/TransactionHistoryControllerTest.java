package ru.aston.mcs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.aston.mcs.dto.TransactionHistoryDTO;
import ru.aston.mcs.entity.enums.Operation;
import ru.aston.mcs.service.TransactionHistoryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionHistoryController.class)
class TransactionHistoryControllerTest {

    @MockBean
    private TransactionHistoryService transactionHistoryService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void createTransactionHistory() throws Exception {
        TransactionHistoryDTO transactionHistoryDTO = new TransactionHistoryDTO(1L, null, 100.0, Operation.DECREASE, "something1", new Date());

        mockMvc.perform(post("/api/transaction-histories/").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(transactionHistoryDTO)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void returnListOfTransactionHistories() throws Exception {
        List<TransactionHistoryDTO> transactionHistories = new ArrayList<>(
                Arrays.asList(new TransactionHistoryDTO(1L, null, 100.0, Operation.DECREASE, "something1", new Date()),
                        new TransactionHistoryDTO(2L, null, 200.0, Operation.INCREASE, "something2", new Date()),
                        new TransactionHistoryDTO(3L, null, 300.0, Operation.DECREASE, "something3", new Date()))
        );

        when(transactionHistoryService.getAllTransactionHistories()).thenReturn(transactionHistories);
        mockMvc.perform(get("/api/transaction-histories/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(transactionHistories.size()))
                .andDo(print());
    }

    @Test
    void returnTransactionHistory() throws Exception {
        long id = 1L;
        TransactionHistoryDTO transactionHistoryDTO = new TransactionHistoryDTO(1L, null, 100.0, Operation.DECREASE, "something1", new Date());
        when(transactionHistoryService.getTransactionHistory(id)).thenReturn(transactionHistoryDTO);
        mockMvc.perform(get("/api/transaction-histories/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andDo(print());
    }

    @Test
    void updateTransactionHistory() throws Exception {
        TransactionHistoryDTO newTransactionHistoryDTO = new TransactionHistoryDTO(null, null, 100.0, Operation.INCREASE, "something2", new Date());
        TransactionHistoryDTO oldTransactionHistoryDTO = new TransactionHistoryDTO(1L, null, 100.0, Operation.DECREASE, "something1", new Date());
        TransactionHistoryDTO updatedTransactionHistoryDTO = new TransactionHistoryDTO(1L, null, 100.0, Operation.INCREASE, "something2", new Date());

        Mockito.when(transactionHistoryService.updateTransactionHistory(oldTransactionHistoryDTO.getId(), newTransactionHistoryDTO)).thenReturn(updatedTransactionHistoryDTO);


        mockMvc.perform(put("/api/transaction-histories/{id}", oldTransactionHistoryDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newTransactionHistoryDTO)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteTransactionHistory() throws Exception {
        long id = 1L;

        doNothing().when(transactionHistoryService).deleteTransactionHistory(id);
        mockMvc.perform(delete("/api/transaction-histories/{id}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
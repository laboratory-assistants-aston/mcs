package ru.aston.mcs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.aston.mcs.dto.BalanceHistoryDTO;
import ru.aston.mcs.entity.enums.Operation;
import ru.aston.mcs.service.BalanceHistoryService;

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

@WebMvcTest(BalanceHistoryController.class)
class BalanceHistoryControllerTest {

    @MockBean
    private BalanceHistoryService balanceHistoryService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void createBalanceHistory() throws Exception {
        BalanceHistoryDTO balanceHistoryDTO = new BalanceHistoryDTO(1L, null, 100.0, Operation.DECREASE, "something1", new Date());

        mockMvc.perform(post("/api/balance-histories/").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(balanceHistoryDTO)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void returnListOfBalanceHistories() throws Exception {
        List<BalanceHistoryDTO> balanceHistories = new ArrayList<>(
                Arrays.asList(new BalanceHistoryDTO(1L, null, 100.0, Operation.DECREASE, "something1", new Date()),
                        new BalanceHistoryDTO(2L, null, 200.0, Operation.INCREASE, "something2", new Date()),
                        new BalanceHistoryDTO(3L, null, 300.0, Operation.DECREASE, "something3", new Date()))
        );

        when(balanceHistoryService.getAllBalanceHistories()).thenReturn(balanceHistories);
        mockMvc.perform(get("/api/balance-histories/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(balanceHistories.size()))
                .andDo(print());
    }

    @Test
    void returnBalanceHistory() throws Exception {
        long id = 1L;
        BalanceHistoryDTO balanceHistoryDTO = new BalanceHistoryDTO(1L, null, 100.0, Operation.DECREASE, "something1", new Date());
        when(balanceHistoryService.getBalanceHistory(id)).thenReturn(balanceHistoryDTO);
        mockMvc.perform(get("/api/balance-histories/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andDo(print());
    }

    @Test
    void updateBalanceHistory() throws Exception {
        BalanceHistoryDTO balanceHistoryDTO = new BalanceHistoryDTO(1L, null, 100.0, Operation.DECREASE, "something1", new Date());

        mockMvc.perform(put("/api/balance-histories/").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(balanceHistoryDTO)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteBalanceHistory() throws Exception {
        long id = 1L;

        doNothing().when(balanceHistoryService).deleteBalanceHistory(id);
        mockMvc.perform(delete("/api/balance-histories/{id}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
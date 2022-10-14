package ru.aston.mcs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.aston.mcs.dto.StatusDTO;
import ru.aston.mcs.service.StatusService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(StatusController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StatusControllerTest {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @MockBean
    StatusService statusService;


    @BeforeAll
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(
                new StatusController(statusService)).build();

        objectMapper = new ObjectMapper();
    }

    @Test
    void getAllStatus() throws Exception {

        List<StatusDTO> dto = new ArrayList<>();
        dto.add(new StatusDTO(1L, "BOOKING"));
        dto.add(new StatusDTO(2L, "READY_TO_USE"));

        Mockito.when(statusService.getAllStatus()).thenReturn(dto);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/status/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(dto.size())))
                .andExpect(content().contentType("application/json"))
                .andDo(print());
    }


    @Test
    void getStatus() throws Exception {

        StatusDTO dto = new StatusDTO(1L, "BOOKING");

        Mockito.when(statusService.getStatus(dto.getStatusId())).thenReturn(dto);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/status/{id}", dto.getStatusId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(content().contentType("application/json"))
                .andDo(print());
    }

    @Test
    void saveStatus() throws Exception {

        StatusDTO dto = new StatusDTO(1L, "BOOKING");

        Mockito.when(statusService.createStatus(dto)).thenReturn(dto);

        MockHttpServletRequestBuilder mockRequest =
                MockMvcRequestBuilders.post("/api/status/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(dto));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void updateStatus() throws Exception {

        StatusDTO dto = new StatusDTO(null, "LOCK");
        StatusDTO oldStatus = new StatusDTO(1L, "BOOK");
        StatusDTO updatedStatus = new StatusDTO(1L, "LOCK");

        Mockito.when(statusService.updateStatus(oldStatus.getStatusId(), dto)).thenReturn(updatedStatus);

        mockMvc.perform(put("/api/status/{id}", oldStatus.getStatusId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void updateTypeResourcesBadRequest() throws Exception {

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/status/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(null));

        mockMvc.perform(mockRequest)
                .andExpect(status().isBadRequest());
    }

    @Test
    void deleteStatus() throws Exception {

        StatusDTO dto = new StatusDTO(1L, "BOOKING");

        Mockito.doNothing().when(statusService).deleteStatus(dto.getStatusId());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/status/{id}", dto.getStatusId()))
                .andExpect(status().isOk())
                .andDo(print());
    }
}

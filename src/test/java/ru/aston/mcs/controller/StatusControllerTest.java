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
import ru.aston.mcs.util.StatusDataUtils;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
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

        List<StatusDTO> dto = StatusDataUtils.createStatusDTOList();

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

        StatusDTO dto = StatusDataUtils.createStatusDTO();

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

        StatusDTO dto = StatusDataUtils.createStatusDTO();

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

        StatusDTO dto = StatusDataUtils.createStatusDTO();

        MockHttpServletRequestBuilder mockRequest =
                MockMvcRequestBuilders.put("/api/status/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(dto));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteStatus() throws Exception {

        StatusDTO dto = StatusDataUtils.createStatusDTO();

        Mockito.doNothing().when(statusService).deleteStatus(dto.getStatusId());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/status/{id}", dto.getStatusId()))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
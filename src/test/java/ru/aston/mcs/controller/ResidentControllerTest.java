package ru.aston.mcs.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.aston.mcs.dto.ResidentDTO;
import ru.aston.mcs.service.ResidentService;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest(ResidentController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ResidentControllerTest {
    @MockBean
    private ResidentService residentService;

    ResidentDTO residentDTO;

    private MockMvc mockMvc;

    @BeforeAll
    void setUp() {
        mockMvc = standaloneSetup(new ResidentController(residentService)).build();
        residentDTO = new ResidentDTO
                (0L, null, "5855715", "www-Leningrad", 0.0, null,
                        null);
    }

    @Test
    void getAllResidentsTest() throws Exception {
        when(residentService.getAllResident()).thenReturn(Collections.singletonList(residentDTO));
        MvcResult mvcResult = mockMvc
                .perform(get("/api/residents/"))
                .andReturn();
        verifyBody(asJsonString(Collections.singletonList(residentDTO)), mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getResidentByIdTest() throws Exception {
        when(residentService.getResident(0L)).thenReturn(residentDTO);
        MvcResult mvcResult = mockMvc
                .perform(get("/api/residents/0").param("id", "0"))
                .andReturn();
        verifyBody(asJsonString(residentDTO), mvcResult.getResponse().getContentAsString());
    }

    @Test
    void saveResidentByDtoTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/api/residents/")
                        .characterEncoding("utf-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(residentDTO)))
                .andExpect(status().isOk())
                .andReturn();
        verifyBody(asJsonString(residentDTO), mvcResult.getRequest().getContentAsString());
    }

    @Test
    void updateResidentByDtoTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(put("/api/residents/")
                        .characterEncoding("utf-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(residentDTO)))
                .andExpect(status().isOk())
                .andReturn();
        verifyBody(asJsonString(residentDTO), mvcResult.getRequest().getContentAsString());
    }

    @Test
    void deleteResidentByIdTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(delete("/api/residents/0")
                        .characterEncoding("utf-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(0)))
                .andExpect(status().isOk())
                .andReturn();
        verifyBody(asJsonString(0), mvcResult.getRequest().getContentAsString());
    }

    private static String asJsonString(final Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }

    private void verifyBody(String expectedBody, String actualBody) {
        assertThat(actualBody).isEqualTo(expectedBody);
    }
}
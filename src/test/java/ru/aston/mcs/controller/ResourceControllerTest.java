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
import ru.aston.mcs.dto.ResourceDTO;
import ru.aston.mcs.service.ResourceService;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest(ResourceController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ResourceControllerTest {
    @MockBean
    private ResourceService resourceService;

    ResourceDTO resourceDTO;

    private MockMvc mockMvc;

    @BeforeAll
    void setUp() {
        mockMvc = standaloneSetup(new ResourceController(resourceService)).build();
        resourceDTO = new ResourceDTO(0L, "", null, null);
    }

    @Test
    void getAllResourcesTest() throws Exception {
        when(resourceService.getAllResource()).thenReturn(Collections.singletonList(resourceDTO));
        MvcResult mvcResult = mockMvc
                .perform(get("/api/resources/"))
                .andReturn();
        verifyBody(asJsonString(Collections.singletonList(resourceDTO)), mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getResourceByIdTest() throws Exception {
        when(resourceService.getResource(0L)).thenReturn(resourceDTO);
        MvcResult mvcResult = mockMvc
                .perform(get("/api/resources/0").param("id", "0"))
                .andReturn();
        verifyBody(asJsonString(resourceDTO), mvcResult.getResponse().getContentAsString());
    }

    @Test
    void saveResourceByDtoTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/api/resources/")
                        .characterEncoding("utf-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(resourceDTO)))
                .andExpect(status().isOk())
                .andReturn();
        verifyBody(asJsonString(resourceDTO), mvcResult.getRequest().getContentAsString());
    }

    @Test
    void updateResourceByDtoTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(put("/api/resources/1")
                        .characterEncoding("utf-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(1))
                        .content(asJsonString(resourceDTO)))
                .andExpect(status().isOk())
                .andReturn();
        verifyBody(asJsonString(resourceDTO), mvcResult.getRequest().getContentAsString());
    }

    @Test
    void deleteResourceByIdTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(delete("/api/resources/0")
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
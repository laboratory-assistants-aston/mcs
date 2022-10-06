package ru.aston.mcs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.aston.mcs.dto.ManagerDTO;
import ru.aston.mcs.service.ManagerService;

import java.util.ArrayList;
import java.util.Arrays;
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

@WebMvcTest(ManagerController.class)
public class ManagerControllerTest {
    @MockBean
    private ManagerService managerService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void shouldReturnListOfManagers() throws Exception {
        List<ManagerDTO> managers = new ArrayList<>(
                Arrays.asList(new ManagerDTO(1L, null, "name", "jobTitle", "surname"),
                        new ManagerDTO(2L, null, "name2", "jobTitle2", "surname2"),
                        new ManagerDTO(3L, null, "name3", "jobTitle3", "surname3"))
        );

        when(managerService.getAllManagers()).thenReturn(managers);
        mockMvc.perform(get("/api/managers/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(managers.size()))
                .andDo(print());
    }

    @Test
    void shouldCreateManager() throws Exception {
        ManagerDTO managerDTO = new ManagerDTO(1L, null, "name", "jobTitle", "surname");

        mockMvc.perform(post("/api/managers/").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(managerDTO)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void shouldReturnManager() throws Exception {
        long id = 1L;
        ManagerDTO managerDTO = new ManagerDTO(1L, null, "name", "jobTitle", "surname");
        when(managerService.getManager(id)).thenReturn(managerDTO);
        mockMvc.perform(get("/api/managers/{id}", id)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andDo(print());
    }

    @Test
    void shouldUpdateManager() throws Exception {
        ManagerDTO managerDTO = new ManagerDTO(1L, null, "name", "jobTitle", "surname");

        mockMvc.perform(put("/api/managers/").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(managerDTO)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void shouldDeleteManager() throws Exception {
        long id = 1L;

        doNothing().when(managerService).deleteManager(id);
        mockMvc.perform(delete("/api/managers/{id}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }
}

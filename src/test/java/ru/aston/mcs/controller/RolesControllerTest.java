package ru.aston.mcs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.aston.mcs.dto.RolesDTO;
import ru.aston.mcs.service.RolesService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RolesController.class)
public class RolesControllerTest {
    @MockBean
    private RolesService rolesService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void shouldCreateRole() throws Exception {
        RolesDTO rolesDTO = new RolesDTO(1L, "name", null);

        mockMvc.perform(post("/api/roles/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(rolesDTO)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void shouldReturnListOfRoles() throws Exception {
        List<RolesDTO> roles = new ArrayList<>(
                Arrays.asList(new RolesDTO(1L, "name", null),
                        new RolesDTO(2L, "name2", null),
                        new RolesDTO(3L, "name3", null)));
        when(rolesService.getAllRoles()).thenReturn(roles);
        mockMvc.perform(get("/api/roles/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(roles.size()))
                .andDo(print());
    }

    @Test
    void shouldReturnRole() throws Exception {
        long id = 1L;
        RolesDTO rolesDTO = new RolesDTO(1L, "name", null);
        when(rolesService.getRole(id)).thenReturn(rolesDTO);
        mockMvc.perform(get("/api/roles/{id}", id)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andDo(print());
    }

    @Test
    void shouldUpdateRole() throws Exception {
        RolesDTO rolesDTO = new RolesDTO(1L, "name", null);

        mockMvc.perform(put("/api/roles/").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(rolesDTO)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void shouldDeleteRole() throws Exception {
        long id = 1L;

        doNothing().when(rolesService).deleteRole(id);
        mockMvc.perform(delete("/api/roles/{id}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }
}

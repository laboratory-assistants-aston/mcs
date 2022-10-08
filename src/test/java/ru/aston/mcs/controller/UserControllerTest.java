package ru.aston.mcs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.aston.mcs.dto.UserDTO;
import ru.aston.mcs.service.UserService;

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

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void shouldReturnListOfUsers() throws Exception {
        List<UserDTO> users = new ArrayList<>(
                Arrays.asList(new UserDTO(1L, 123, "login1", "email1", "phone", "address", 2.2F, null),
                        new UserDTO(2L, 123, "login2", "email2", "phone2", "address2", 2.2F, null),
                        new UserDTO(3L, 123, "login3", "email3", "phone3", "address3", 2.2F, null))
        );

        when(userService.getAllUsers()).thenReturn(users);
        mockMvc.perform(get("/api/users/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(users.size()))
                .andDo(print());
    }

    @Test
    void shouldCreateUser() throws Exception {
        UserDTO userDTO = new UserDTO(1L, 123, "login1", "email1", "phone", "address", 2.2F, null);

        mockMvc.perform(post("/api/users/").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void shouldReturnUser() throws Exception {
        long id = 1L;
        UserDTO userDTO = new UserDTO(1L, 123, "login1", "email1", "phone", "address", 2.2F, null);
        when(userService.getUser(id)).thenReturn(userDTO);
        mockMvc.perform(get("/api/users/{id}", id)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andDo(print());
    }

    @Test
    void shouldUpdateUser() throws Exception {
        UserDTO userDTO = new UserDTO(1L, 123, "login1", "email1", "phone", "address", 2.2F, null);

        mockMvc.perform(put("/api/users/").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void shouldDeleteUser() throws Exception {
        long id = 1L;

        doNothing().when(userService).deleteUser(id);
        mockMvc.perform(delete("/api/users/{id}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }
}

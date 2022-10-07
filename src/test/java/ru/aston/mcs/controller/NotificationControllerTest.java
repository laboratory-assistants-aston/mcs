package ru.aston.mcs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.aston.mcs.dto.NotificationDTO;
import ru.aston.mcs.service.NotificationService;

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

@WebMvcTest(NotificationController.class)
class NotificationControllerTest {

    @MockBean
    private NotificationService notificationService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void returnListOfNotifications() throws Exception {
        List<NotificationDTO> notifications = new ArrayList<>(
                Arrays.asList(new NotificationDTO(1L, "firstText", null, null),
                        new NotificationDTO(2L, "secondText", null, null),
                        new NotificationDTO(3L, "secondText", null, null))
        );

        when(notificationService.getAllNotifications()).thenReturn(notifications);
        mockMvc.perform(get("/api/notifications/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(notifications.size()))
                .andDo(print());
    }

    @Test
    void createNotification() throws Exception {
        NotificationDTO notificationDTO = new NotificationDTO(1L, "firstText", null, null);

        mockMvc.perform(post("/api/notifications/").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(notificationDTO)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void updateNotification() throws Exception {
        NotificationDTO notificationDTO = new NotificationDTO(1L, "firstText", null, null);

        mockMvc.perform(put("/api/notifications/").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(notificationDTO)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteNotification() throws Exception {
        long id = 1L;

        doNothing().when(notificationService).deleteNotification(id);
        mockMvc.perform(delete("/api/notifications/{id}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
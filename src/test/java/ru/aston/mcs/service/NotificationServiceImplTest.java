package ru.aston.mcs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.mcs.dto.NotificationsRequestDTO;
import ru.aston.mcs.mapper.NotificationMapper;
import ru.aston.mcs.repository.NotificationRepository;
import ru.aston.mcs.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class NotificationServiceImplTest {

    @Mock
    private NotificationRepository notificationRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private NotificationMapper notificationMapper;

    @InjectMocks
    private ru.aston.mcs.service.impl.NotificationServiceImpl notificationService;

    private NotificationsRequestDTO notificationsRequestDTO;

    @BeforeEach
    void createDto() {
        NotificationsRequestDTO notificationsRequestDTO = new NotificationsRequestDTO();
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        notificationsRequestDTO.setUser(list);
        notificationsRequestDTO.setDate(new Date());
        notificationsRequestDTO.setText(null);
        notificationsRequestDTO.setId(1L);
    }

    @Test
    void getAllNotifications() {
        notificationService.getAllNotifications();
        Mockito.verify(notificationRepository).findAll();
    }

    @Test
    void getNotificationByIdTest() {
        RuntimeException runtimeException =
                assertThrows(RuntimeException.class, () -> notificationService.getNotification(1L));
        Mockito.verify(notificationRepository).findById(1L);
    }

    @Test
    void deleteNotificationByIdTest() {
        notificationService.deleteNotification(1L);
        Mockito.verify(notificationRepository).deleteById(1L);
    }
}
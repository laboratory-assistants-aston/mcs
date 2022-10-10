package ru.aston.mcs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.mcs.dto.NotificationDTO;
import ru.aston.mcs.mapper.NotificationMapper;
import ru.aston.mcs.repository.NotificationRepository;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NotificationServiceImplTest {

    @Mock
    private NotificationRepository notificationRepository;
    @Mock
    private NotificationMapper notificationMapper;

    @InjectMocks
    private ru.aston.mcs.service.impl.NotificationServiceImpl notificationService;

    private NotificationDTO notificationDTO;

    @BeforeEach
    void createDto() {
        notificationDTO = new NotificationDTO();
        notificationDTO.setDate(new Date());
        notificationDTO.setText(null);
        notificationDTO.setUser(null);
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

//    @Test
//    void createNotificationFromDtoTest() {
//        notificationService.createNotification(notificationDTO);
//        Mockito.verify(notificationRepository).save(notificationMapper.toModel(notificationDTO));
//    }

    @Test
    void deleteNotificationByIdTest() {
        notificationService.deleteNotification(1L);
        Mockito.verify(notificationRepository).deleteById(1L);
    }
}
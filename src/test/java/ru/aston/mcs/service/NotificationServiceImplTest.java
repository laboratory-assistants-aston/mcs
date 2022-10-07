package ru.aston.mcs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.mcs.dto.BalanceHistoryDTO;
import ru.aston.mcs.dto.NotificationDTO;
import ru.aston.mcs.entity.enums.Operation;
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
        notificationDTO.setManager(null);
        notificationDTO.setText(null);
        notificationDTO.setResident(null);
    }

    @Test
    void getAllBalanceHistories() {
        notificationService.getAllNotifications();
        Mockito.verify(notificationRepository).findAll();
    }

    @Test
    void getBalanceHistoryByIdTest() {
        RuntimeException runtimeException =
                assertThrows(RuntimeException.class, () -> notificationService.getNotification(1L));
        Mockito.verify(notificationRepository).findById(1L);
    }

    @Test
    void createBalanceHistoryFromDtoTest() {
        notificationService.addAndSaveNotification(notificationDTO);
        Mockito.verify(notificationRepository).save(notificationMapper.toModel(notificationDTO));
    }

    @Test
    void deleteBalanceHistoryByIdTest() {
        notificationService.deleteNotification(1L);
        Mockito.verify(notificationRepository).deleteById(1L);
    }
}
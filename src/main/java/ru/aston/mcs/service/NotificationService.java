package ru.aston.mcs.service;

import ru.aston.mcs.dto.NotificationResponseDTO;
import ru.aston.mcs.dto.NotificationsRequestDTO;

import java.util.List;

public interface NotificationService {
    List<NotificationResponseDTO> getAllNotifications();

    NotificationResponseDTO updateNotification(NotificationsRequestDTO notificationsRequestDTO);

    void createNotification(NotificationsRequestDTO notificationsRequestDTO);

    void deleteNotification(Long notificationId);

    NotificationResponseDTO getNotification(Long notificationId);

    List<NotificationResponseDTO> getAllNotificationsByUserId(Long id);

    NotificationResponseDTO getLastNotificationByUserId(Long id);

    void createNotificationAsList(NotificationsRequestDTO notificationsRequestDTO);
}
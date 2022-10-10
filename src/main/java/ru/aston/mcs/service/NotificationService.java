package ru.aston.mcs.service;

import ru.aston.mcs.dto.NotificationDTO;
import ru.aston.mcs.dto.NotificationsRequestDTO;

import java.util.List;

public interface NotificationService {
    List<NotificationDTO> getAllNotifications();

    NotificationDTO updateNotification(NotificationDTO notification);

    NotificationDTO createNotification(NotificationDTO notification);

    void deleteNotification(Long notificationId);

    NotificationDTO getNotification(Long notificationId);

    List<NotificationDTO> getAllNotificationsByUserId(Long id);

    NotificationDTO getLastNotificationByUserId(Long id);

    List<NotificationDTO> createNotificationAsList(NotificationsRequestDTO notificationsRequestDTO);

}
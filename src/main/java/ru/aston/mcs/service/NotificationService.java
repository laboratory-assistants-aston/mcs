package ru.aston.mcs.service;

import ru.aston.mcs.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {
    List<NotificationDTO> getAllNotifications();

    NotificationDTO updateNotification(NotificationDTO notification);

    NotificationDTO createNotification(NotificationDTO notification);

    void deleteNotification(Long notificationId);

    NotificationDTO getNotification(Long notificationId);

    List<NotificationDTO> getAllNotificationsByUserId(Long id);
}
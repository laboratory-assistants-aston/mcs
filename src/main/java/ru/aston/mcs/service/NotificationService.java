package ru.aston.mcs.service;

import ru.aston.mcs.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {
    List<NotificationDTO> getAllNotifications();

    NotificationDTO updateNotification(Long id, NotificationDTO notification);

    NotificationDTO createNotification(NotificationDTO notification);

    void deleteNotification(Long notificationId);

    NotificationDTO getNotification(Long notificationId);
}

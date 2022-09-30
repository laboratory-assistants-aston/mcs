package ru.aston.mcs.service;

import ru.aston.mcs.entity.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> getAllNotifications();

    void saveNotification(Notification notification);

    void deleteNotification(Long notificationId);

    Notification getNotification(Long notificationId);
}

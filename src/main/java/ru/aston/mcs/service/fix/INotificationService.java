package ru.aston.mcs.service.fix;

import ru.aston.mcs.dto.request.NotificationRequest;
import ru.aston.mcs.dto.response.NotificationResponse;

import java.util.List;

public interface INotificationService {

    List<NotificationResponse> getAll();

    NotificationResponse get(Long id);

    NotificationResponse create(NotificationRequest notificationRequest);

    NotificationResponse update(Long id, NotificationRequest notificationRequest);

    void delete(Long id);
}


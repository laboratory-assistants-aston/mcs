package ru.aston.mcs.mapper.fix;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.request.NotificationRequest;
import ru.aston.mcs.dto.response.NotificationResponse;
import ru.aston.mcs.entity.Notification;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewNotificationMapper {

    Notification toEntity(NotificationRequest notificationRequest);

    NotificationResponse toResponse(Notification notification);

    List<NotificationResponse> toResponseList(List<Notification> notification);

}

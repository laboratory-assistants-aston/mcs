package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.NotificationDTO;
import ru.aston.mcs.entity.Notification;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    Notification notificationDtoInNotification(NotificationDTO notificationDTO);

    NotificationDTO notificationInNotificationDTO(Notification notification);
}

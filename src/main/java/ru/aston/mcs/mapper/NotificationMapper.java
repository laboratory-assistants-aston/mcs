package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.NotificationResponseDTO;
import ru.aston.mcs.dto.NotificationsRequestDTO;
import ru.aston.mcs.entity.Notification;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    List<NotificationResponseDTO> toDTOResponseList(List<Notification> notificationList);

    NotificationResponseDTO toDTOResponse(Notification notification);

    NotificationsRequestDTO toDTORequest(Notification notification);

    Notification toModel(NotificationsRequestDTO notificationDTO);
}
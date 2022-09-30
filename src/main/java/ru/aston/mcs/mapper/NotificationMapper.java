package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.NotificationDTO;
import ru.aston.mcs.entity.Notification;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    Notification toModel(NotificationDTO notificationDTO);

    NotificationDTO toDTO(Notification notification);

    List<Notification> toModelList(List<NotificationDTO> resourceDetailsDTOList);

    List<NotificationDTO> toDTOList(List<Notification> modelList);
}

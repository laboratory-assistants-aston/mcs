package ru.aston.mcs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.aston.mcs.entity.Manager;
import ru.aston.mcs.entity.Users;

@Data
@Builder
@AllArgsConstructor
public class NotificationDTO {
    private int notificationId;
    private String text;
    private Users user;
    private Manager manager;
}

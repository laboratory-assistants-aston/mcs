package ru.aston.mcs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.aston.mcs.entity.Manager;
import ru.aston.mcs.entity.Users;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
    private Long notificationId;
    private String text;
    private Users user;
    private Manager manager;
}

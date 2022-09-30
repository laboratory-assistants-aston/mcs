package ru.aston.mcs.dto;

import lombok.*;
import ru.aston.mcs.entity.Manager;
import ru.aston.mcs.entity.Users;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class NotificationDTO {
    private Long notificationId;
    private String text;
    private Users user;
    private Manager manager;
}

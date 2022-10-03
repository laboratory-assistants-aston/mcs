package ru.aston.mcs.dto;

import ru.aston.mcs.entity.Manager;
import ru.aston.mcs.entity.Users;

public class NotificationDTO {
    private Long notificationId;
    private String text;
    private Users user;
    private Manager manager;

    public NotificationDTO() {
    }

    public NotificationDTO(Long notificationId, String text, Users user, Manager manager) {
        this.notificationId = notificationId;
        this.text = text;
        this.user = user;
        this.manager = manager;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}

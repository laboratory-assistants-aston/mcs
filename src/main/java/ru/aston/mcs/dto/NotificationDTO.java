package ru.aston.mcs.dto;

import ru.aston.mcs.entity.User;

import java.util.Date;

public class NotificationDTO {
    private Long notificationId;
    private String text;
    private User user;
    private Date date;

    public NotificationDTO() {
    }

    public NotificationDTO(Long notificationId, String text, User user, Date date) {
        this.notificationId = notificationId;
        this.text = text;
        this.user = user;
        this.date = date;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
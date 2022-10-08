package ru.aston.mcs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.aston.mcs.entity.User;

import java.util.Date;

@ApiModel(value = "Table which shows information about notification")
public class NotificationDTO {

    private Long notificationId;

    @ApiModelProperty(value = "Notification's text")
    private String text;

    @ApiModelProperty(value = "User who get notifications")
    private User user;

    @ApiModelProperty(value = "Date when notification sends")
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
package ru.aston.mcs.dto.request;

import ru.aston.mcs.entity.User;

import java.util.Date;

public class NotificationRequest {

    private User user;

    private String text;

    private Date creationDate;

    public NotificationRequest() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
package ru.aston.mcs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @Column(name = "notification_id")
    private int notificationId;

    @Column
    private String text;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "manager_id")
    private int managerId;

    public Notification() {
    }

    public Notification(String text, int userId, int managerId) {
        this.text = text;
        this.userId = userId;
        this.managerId = managerId;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}

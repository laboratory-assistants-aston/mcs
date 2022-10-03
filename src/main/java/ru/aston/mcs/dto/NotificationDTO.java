package ru.aston.mcs.dto;

import ru.aston.mcs.entity.Manager;
import ru.aston.mcs.entity.Resident;

public class NotificationDTO {
    private Long notificationId;
    private String text;
    private Resident resident;
    private Manager manager;

    public NotificationDTO() {
    }

    public NotificationDTO(Long notificationId, String text, Resident user, Manager manager) {
        this.notificationId = notificationId;
        this.text = text;
        this.resident = user;
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

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
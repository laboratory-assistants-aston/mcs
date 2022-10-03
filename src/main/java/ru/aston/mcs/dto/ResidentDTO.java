package ru.aston.mcs.dto;

import ru.aston.mcs.entity.Notification;
import ru.aston.mcs.entity.Resource;

import java.util.List;

public class ResidentDTO {
    private Long id;

    private User userId;

    private String phone;

    private String address;

    private Float balance;

    private List<Notification> notifications;

    private List<Resource> resources;

    public ResidentDTO() {
    }

    public ResidentDTO(Long id, User userId, String phone, String address, Float balance,
                       List<Notification> notifications, List<Resource> resources) {
        this.id = id;
        this.userId = userId;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
        this.notifications = notifications;
        this.resources = resources;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public Long getId() {
        return id;
    }

    public User getUserId() {
        return userId;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Float getBalance() {
        return balance;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public List<Resource> getResources() {
        return resources;
    }
}

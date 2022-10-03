package ru.aston.mcs.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "residents")
public class Resident {
    @Id
    @Column(name = "resident_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @Column(name = "resident_address", length = 40, nullable = false)
    private String address;

    @Column(name = "balance", nullable = false)
    private Float balance;

    @ManyToMany
    @JoinTable(name = "sending_notifications"
            , joinColumns = @JoinColumn(name = "resident_id"), inverseJoinColumns = @JoinColumn(name = "notification_id"))
    private List<Notification> notifications;

    @ManyToMany
    @JoinTable(name = "booking_resources"
            , joinColumns = @JoinColumn(name = "resident_id"), inverseJoinColumns = @JoinColumn(name = "resource_id"))
    private List<Resource> resources;

    public Resident() {

    }

    public Resident(Long id, User userId, String phone, String address, Float balance) {
        this.id = id;
        this.userId = userId;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
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
}

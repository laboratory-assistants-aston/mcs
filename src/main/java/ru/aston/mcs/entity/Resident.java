package ru.aston.mcs.entity;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import java.util.List;

@Entity
@Table(name = "residents")
public class Resident {

    @Id
    @Column(name = "resident_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long residentId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @Column(name = "resident_address", length = 40, nullable = false)
    private String address;

    @Column(name = "balance", nullable = false, precision = 10, scale = 2)
    private Double balance;

    @ManyToMany
    @JoinTable(name = "sending_notifications",
            joinColumns = @JoinColumn(name = "resident_id"),
            inverseJoinColumns = @JoinColumn(name = "notification_id"))
    private List<Notification> notifications;

    @ManyToMany
    @JoinTable(name = "booking_resources_residents",
            joinColumns = @JoinColumn(name = "resident_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id"))
    private List<BookingResource> resources;

    public Resident() {

    }

    public Resident(Long residentId, User userId, String phone, String address, Double balance) {
        this.residentId = residentId;
        this.userId = userId;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
    }

    public void setId(Long id) {
        this.residentId = residentId;
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

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getId() {
        return residentId;
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

    public Double getBalance() {
        return balance;
    }
}

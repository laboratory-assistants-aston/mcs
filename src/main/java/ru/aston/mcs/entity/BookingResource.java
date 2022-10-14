package ru.aston.mcs.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking_resources")
public class BookingResource {

    @Id
    @Column(name = "booking_resources_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "duration_time", nullable = false)
    private Integer durationTime;

    @Column(name = "start_booking", nullable = false)
    private Date startBooking;

    @Column(name = "end_booking", nullable = false)
    private Date endBooking;

    public BookingResource() {
    }

    public BookingResource(Long id, Resource resource, Status status, Integer durationTime, Date startBooking, Date endBooking, User user) {
        this.id = id;
        this.resource = resource;
        this.status = status;
        this.durationTime = durationTime;
        this.startBooking = startBooking;
        this.endBooking = endBooking;
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDurationTime(Integer durationTime) {
        this.durationTime = durationTime;
    }

    public void setStartBooking(Date startBooking) {
        this.startBooking = startBooking;
    }

    public void setEndBooking(Date endBooking) {
        this.endBooking = endBooking;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Resource getResource() {
        return resource;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getDurationTime() {
        return durationTime;
    }

    public Date getStartBooking() {
        return startBooking;
    }

    public Date getEndBooking() {
        return endBooking;
    }

    public User getUser() {
        return user;
    }
}
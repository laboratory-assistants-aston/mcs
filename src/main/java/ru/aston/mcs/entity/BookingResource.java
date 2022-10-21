package ru.aston.mcs.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "booking_resources")
public class BookingResource {

    @Id
    @Column(name = "booking_resources_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "duration_time", nullable = false)
    private Integer durationTime;

    @Column(name = "start_booking", nullable = false)
    private LocalDateTime startBooking;

    @Column(name = "end_booking", nullable = false)
    private LocalDateTime endBooking;

    public BookingResource() {
    }

    public BookingResource(Long id, Resource resource, Status status, User user, Integer durationTime, LocalDateTime startBooking, LocalDateTime endBooking) {
        this.id = id;
        this.resource = resource;
        this.status = status;
        this.user = user;
        this.durationTime = durationTime;
        this.startBooking = startBooking;
        this.endBooking = endBooking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Integer durationTime) {
        this.durationTime = durationTime;
    }

    public LocalDateTime getStartBooking() {
        return startBooking;
    }

    public void setStartBooking(LocalDateTime startBooking) {
        this.startBooking = startBooking;
    }

    public LocalDateTime getEndBooking() {
        return endBooking;
    }

    public void setEndBooking(LocalDateTime endBooking) {
        this.endBooking = endBooking;
    }
}
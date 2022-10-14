package ru.aston.mcs.dto.response;

import ru.aston.mcs.entity.Resource;
import ru.aston.mcs.entity.Status;
import ru.aston.mcs.entity.User;

import java.time.LocalDateTime;
import java.util.Date;

public class BookingResourceResponse {

    private Long id;

    private Resource resource;

    private Status status;

    private User user;

    private Integer durationTime;

    private LocalDateTime startBooking;

    private LocalDateTime endBooking;

    public BookingResourceResponse() {

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

package ru.aston.mcs.dto;

import ru.aston.mcs.entity.Resource;
import ru.aston.mcs.entity.Status;

import java.util.Date;

public class BookingResourceDTO {
    private Long id;
    private Resource resource;
    private Status status;
    private Integer durationTime;
    private Date startBooking;
    private Date endBooking;
    private Users user;

    public BookingResourceDTO() {
    }

    public BookingResourceDTO(Long id, Resource resource, Status status, Integer durationTime, Date startBooking, Date endBooking, Users user) {
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

    public void setUser(Users user) {
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

    public Users getUser() {
        return user;
    }
}
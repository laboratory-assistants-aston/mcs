package ru.aston.mcs.dto;

import  ru.aston.mcs.entity.Resident;
import ru.aston.mcs.entity.ResourceType;
import ru.aston.mcs.entity.Status;

import java.util.Date;
import java.util.List;

public class BookingResourceDTO {
    private Long id;
    private ResourceType resourceType;
    private Status status;
    private Integer durationTime;
    private Date startBooking;
    private Date endBooking;
    private List<Resident> residentList;

    public BookingResourceDTO() {
    }

    public BookingResourceDTO(Long id, ResourceType resourceType, Status status, Integer durationTime, Date startBooking, Date endBooking, List<Resident> residentList) {
        this.id = id;
        this.resourceType = resourceType;
        this.status = status;
        this.durationTime = durationTime;
        this.startBooking = startBooking;
        this.endBooking = endBooking;
        this.residentList = residentList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
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

    public void setResidentList(List<Resident> residentList) {
        this.residentList = residentList;
    }

    public Long getId() {
        return id;
    }

    public ResourceType getResourceType() {
        return resourceType;
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

    public List<Resident> getResidentList() {
        return residentList;
    }
}

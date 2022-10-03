package ru.aston.mcs.entity;

import ru.aston.mcs.entity.enums.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "resources")
public class Resource {
    @Id
    @Column(name = "resources_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resource_type_id", nullable = false)
    private ResourceType resourceType;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @Column(name = "duration_time", nullable = false)
    private Integer durationTime;

    @Column(name = "start_booking", nullable = false)
    private Date startBooking;

    @Column(name = "end_booking", nullable = false)
    private Date endBooking;

    @ManyToMany
    @JoinTable(name = "booking_resources"
            , joinColumns = @JoinColumn(name = "resource_id"), inverseJoinColumns = @JoinColumn(name = "resident_id"))
    private List<Resident> residentList;

    public Resource() {
    }

    public Resource(Long id, ResourceType resourceType, Status status, Integer durationTime, Date startBooking, Date endBooking, List<Resident> residentList) {
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
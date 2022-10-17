package ru.aston.mcs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.aston.mcs.entity.Resource;
import ru.aston.mcs.entity.Status;
import ru.aston.mcs.entity.User;

import java.util.Date;
@ApiModel(value = "model for adding data in booking resource table")
public class BookingResourceResponseDTO {

    private Long id;

    @ApiModelProperty(value = "id of resource", example = "1", required = true)
    private Resource resource;

    @ApiModelProperty(value = "id of type status", example = "1", required = true)
    private Status status;

    @ApiModelProperty(value = "duration time of booking", example = "2", required = true)
    private Integer durationTime;

    @ApiModelProperty(value = "date of start booking", example = "22.10.2002", required = true)
    private Date startBooking;

    @ApiModelProperty(value = "date of end booking", example = "22.10.2002", required = true)
    private Date endBooking;

    @ApiModelProperty(value = "id of type user", example = "1", required = true)
    private User user;

    public BookingResourceResponseDTO() {
    }

    public BookingResourceResponseDTO(Long id, Resource resource, Status status,
                                      Integer durationTime, Date startBooking, Date endBooking, User user) {
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
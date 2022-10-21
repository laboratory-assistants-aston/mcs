package ru.aston.mcs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.aston.mcs.entity.Resource;
import ru.aston.mcs.entity.Status;
import ru.aston.mcs.entity.User;

import java.util.Date;

@ApiModel(value = "model for adding data in ResponseBookingResource table")
public class ResponseBookingResourceDTO {

    private Long id;

    @ApiModelProperty(value = "id of resource", example = "1", required = true)
    private Long resource;

    @ApiModelProperty(value = "id of type status", example = "1", required = true)
    private Long status;

    @ApiModelProperty(value = "duration time of booking", example = "2", required = true)
    private Integer durationTime;

    @ApiModelProperty(value = "date of start booking", example = "22.10.2002", required = true)
    private Date startBooking;

    @ApiModelProperty(value = "date of end booking", example = "22.10.2002", required = true)
    private Date endBooking;

    @ApiModelProperty(value = "id of type user", example = "1", required = true)
    private Long user;

    public ResponseBookingResourceDTO(Long id, Long resource, Long status, Integer durationTime, Date startBooking, Date endBooking, Long user) {
        this.id = id;
        this.resource = resource;
        this.status = status;
        this.durationTime = durationTime;
        this.startBooking = startBooking;
        this.endBooking = endBooking;
        this.user = user;
    }

    public ResponseBookingResourceDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResource() {
        return resource;
    }

    public void setResource(Long resource) {
        this.resource = resource;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Integer getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Integer durationTime) {
        this.durationTime = durationTime;
    }

    public Date getStartBooking() {
        return startBooking;
    }

    public void setStartBooking(Date startBooking) {
        this.startBooking = startBooking;
    }

    public Date getEndBooking() {
        return endBooking;
    }

    public void setEndBooking(Date endBooking) {
        this.endBooking = endBooking;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}

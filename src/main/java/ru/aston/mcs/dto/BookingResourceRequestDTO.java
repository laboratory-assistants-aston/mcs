package ru.aston.mcs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import liquibase.pro.packaged.L;
import ru.aston.mcs.entity.Resource;

import java.util.Date;

public class BookingResourceRequestDTO {

    @ApiModelProperty(value = "id of resource", example = "1", required = true)
    private Long resourceId;

    @ApiModelProperty(value = "duration time of booking", example = "2", required = true)
    private Integer durationTime;

    @ApiModelProperty(value = "date of start booking", example = "22-10-2002", required = true)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startBooking;

    public BookingResourceRequestDTO() {
    }

    public BookingResourceRequestDTO(Long resourceId, Integer durationTime, Date startBooking) {
        this.resourceId = resourceId;
        this.durationTime = durationTime;
        this.startBooking = startBooking;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
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

    @Override
    public String toString() {
        return "BookingResourceRequestDTO{" +
                "resourceId=" + resourceId +
                ", durationTime=" + durationTime +
                ", startBooking=" + startBooking +
                '}';
    }
}

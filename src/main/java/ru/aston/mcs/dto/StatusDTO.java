package ru.aston.mcs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.aston.mcs.entity.enums.StatusName;

import java.util.Objects;

@ApiModel(value = "model for adding data in Status table")
public class StatusDTO {

    private Long statusId;

    @ApiModelProperty(value = "name of status", example = "BOOKED", required = true)
    private StatusName statusName;

    public StatusDTO() {

    }

    public StatusDTO(Long statusId, StatusName statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public StatusName getStatusName() {
        return statusName;
    }

    public void setStatusName(StatusName statusName) {
        this.statusName = statusName;
    }
}

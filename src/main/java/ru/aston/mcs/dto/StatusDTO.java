package ru.aston.mcs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "model for adding data in Status table")
public class StatusDTO {

    private Long statusId;

    @ApiModelProperty(value = "name of status", example = "BOOKED", required = true)
    private String statusName;

    public StatusDTO() {

    }

    public StatusDTO(Long statusId, String name) {
        this.statusId = statusId;
        this.statusName = name;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public Long getStatusId() {
        return statusId;
    }


}

package ru.aston.mcs.dto.response;

public class StatusResponse {

    private Long statusId;

    private String statusName;

    public StatusResponse() {

    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}

package ru.aston.mcs.dto;

import java.util.Objects;

/**
 * @author Victoria Zhirnova
 * @project mcs
 */

public class StatusDTO {
    private Long statusId;
    private String name;

    public StatusDTO() {

    }

    public StatusDTO(Long statusId, String name) {
        this.statusId = statusId;
        this.name = name;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusDTO statusDTO = (StatusDTO) o;
        return Objects.equals(statusId, statusDTO.statusId) && Objects.equals(name, statusDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, name);
    }
}

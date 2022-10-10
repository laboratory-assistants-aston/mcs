package ru.aston.mcs.entity;

import com.sun.istack.NotNull;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import java.util.Objects;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long statusId;

    @NotNull
    @Column(name = "status_name", nullable = false)
    private String statusName;

    public Status() {

    }

    public Status(Long statusId, String name) {
        this.statusId = statusId;
        this.statusName = name;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getName() {
        return statusName;
    }

    public void setName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(statusId, status.statusId) && Objects.equals(statusName, status.statusName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, statusName);
    }
}

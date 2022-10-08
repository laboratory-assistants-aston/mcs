package ru.aston.mcs.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name_id")
    private Long statusId;


    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    public Status() {

    }

    public Status(Long statusId, String name) {
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

    public void setName(String statusName) {
        this.name = statusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(statusId, status.statusId) && Objects.equals(name, status.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, name);
    }
}

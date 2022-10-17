package ru.aston.mcs.entity;

import com.sun.istack.NotNull;
import ru.aston.mcs.entity.enums.StatusName;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long statusId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status_name", nullable = false)
    private StatusName status;

    public Status() {

    }

    public Status(Long statusId, StatusName status) {
        this.statusId = statusId;
        this.status = status;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public StatusName getStatus() {
        return status;
    }

    public void setStatus(StatusName status) {
        this.status = status;
    }
}

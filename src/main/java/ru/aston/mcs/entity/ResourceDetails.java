package ru.aston.mcs.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "resource_details")
@AllArgsConstructor
public class ResourceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "details_id")
    private Long detailsId;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "start_time")
    private Date startTime;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "end_time")
    private Date endTime;

    @NotNull
    @Column(name = "information")
    private String information;
}
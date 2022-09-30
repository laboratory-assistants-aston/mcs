package ru.aston.mcs.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
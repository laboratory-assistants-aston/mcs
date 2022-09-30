package ru.aston.mcs.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.aston.mcs.entity.enums.Status;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;

import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resource {
    @Id
    @Column(name = "resources_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "during_time", nullable = false)
    private Integer duringTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "name_id")
    private TypeResources nameId;

    @OneToOne
    @JoinColumn(name = "details_id", nullable = false)
    private ResourceDetails detailsId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users usersId;
}
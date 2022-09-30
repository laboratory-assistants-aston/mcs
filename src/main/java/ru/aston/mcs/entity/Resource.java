package ru.aston.mcs.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

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
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users usersId;
}
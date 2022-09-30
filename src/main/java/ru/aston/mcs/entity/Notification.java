package ru.aston.mcs.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "notifications")
@AllArgsConstructor
public class Notification {

    @Id
    @Column(name = "notification_id")
    private Long notificationId;

    @Column
    private String text;

    @Column(name = "user_id")
    @OneToOne(mappedBy = "userId", cascade = CascadeType.ALL)
    private Users user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "managerId")
    private Manager manager;


}

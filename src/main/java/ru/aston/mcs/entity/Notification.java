package ru.aston.mcs.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;


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

    @JoinColumn(name = "user_id")
    @OneToOne
    private Users user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "managerId")
    private Manager manager;


}

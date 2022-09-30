package ru.aston.mcs.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @Column(name = "notification_id")
    private int notificationId;

    @Column
    private String text;

    @Column(name = "user_id")
    @OneToOne(mappedBy = "userId", cascade = CascadeType.ALL)
    private Users user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "managerId")
    private Manager manager;

    public Notification(String text, Users user, Manager manager) {
        this.text = text;
        this.user = user;
        this.manager = manager;
    }
}

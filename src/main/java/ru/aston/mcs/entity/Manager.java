package ru.aston.mcs.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "managers")
@Entity
public class Manager {
    @Id
    @Column(name = "manager_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "resources_id")
    @OneToMany
    @JoinColumn(name = "manager_id")
    private List<Resource> resourceList;

    @Column(name = "users_id")
    @OneToMany
    @JoinColumn(name = "manager_id")
    private List<User> userList;

    @Column(name = "email")
    private String email;
}

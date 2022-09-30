package ru.aston.mcs.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.aston.mcs.entity.enums.Role;

import javax.persistence.*;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "role_id")
    private Role role;

    @OneToMany
    @JoinColumn(name = "manager_id")
    private List<Resource> resourceList;

    @OneToMany
    @JoinColumn(name = "manager_id")
    private List<Users> userList;

    @Column(name = "email")
    private String email;
}

package ru.aston.mcs.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.aston.mcs.entity.enums.Role;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "housekeeper")
@Entity
public class Housekeeper {
    @Id
    @Column(name = "housekeeper_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;
}

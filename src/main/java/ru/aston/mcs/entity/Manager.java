package ru.aston.mcs.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.aston.mcs.entity.enums.Role;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "managers")
@Entity
@AllArgsConstructor
public class Manager {
    @Id
    @Column(name = "manager_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "resources_id")
    @OneToMany
    @JoinColumn(name = "manager_id")
    private List<Resource> resourceList;

    @Column(name = "users_id")
    @OneToMany
    @JoinColumn(name = "manager_id")
    private List<Users> userList;

    @Column(name = "email")
    private String email;
}

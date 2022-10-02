package ru.aston.mcs.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name="role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="role_name")
    private String roleName;

    @ManyToMany
    @JoinTable(
            name = "persons_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> persons;

    public Role() {
    }

    public Role(Long id, String roleName, List<Person> persons) {
        this.id = id;
        this.roleName = roleName;
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}

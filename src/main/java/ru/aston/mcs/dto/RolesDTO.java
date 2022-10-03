package ru.aston.mcs.dto;

import ru.aston.mcs.entity.Person;

import java.util.List;

public class RolesDTO {
    private Long id;
    private String roleName;
    private List<Person> persons;

    public RolesDTO() {
    }

    public RolesDTO(Long id, String roleName, List<Person> persons) {
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

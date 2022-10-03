package ru.aston.mcs.dto;

import ru.aston.mcs.entity.User;

import java.util.List;

public class RolesDTO {
    private Long id;
    private String roleName;
    private List<User> persons;

    public RolesDTO() {
    }

    public RolesDTO(Long id, String roleName, List<User> persons) {
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

    public List<User> getPersons() {
        return persons;
    }

    public void setPersons(List<User> persons) {
        this.persons = persons;
    }
}

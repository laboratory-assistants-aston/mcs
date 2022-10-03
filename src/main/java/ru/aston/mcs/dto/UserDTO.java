package ru.aston.mcs.dto;

import ru.aston.mcs.entity.Role;

import java.util.List;

public class UserDTO {
    private Long id;
    private Integer accessCode;
    private String login;
    private String email;
    private List<Role> roles;

    public UserDTO() {
    }

    public UserDTO(Long id, Integer accessCode, String login, String email, List<Role> roles) {
        this.id = id;
        this.accessCode = accessCode;
        this.login = login;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(Integer accessCode) {
        this.accessCode = accessCode;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

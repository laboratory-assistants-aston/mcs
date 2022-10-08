package ru.aston.mcs.dto;

import ru.aston.mcs.entity.Role;

import java.util.List;

public class UserDTO {
    private Long id;
    private Integer accessCode;
    private String login;
    private String email;
    private String phone;
    private String address;
    private Float balance;
    private List<Role> roles;

    public UserDTO() {
    }

    public UserDTO(Long id, Integer accessCode, String login, String email, String phone, String address, Float balance, List<Role> roles) {
        this.id = id;
        this.accessCode = accessCode;
        this.login = login;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

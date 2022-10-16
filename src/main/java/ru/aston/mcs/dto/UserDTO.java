package ru.aston.mcs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.aston.mcs.entity.Role;

import java.util.List;
import java.util.Set;

@ApiModel(value = "model for adding data in User table")
public class UserDTO {

    private Long id;

    @ApiModelProperty(value = "access code for resources", example = "1234", required = true)
    private Integer accessCode;

    @ApiModelProperty(value = "user login", example = "adventa", required = true)
    private String userName;

    @ApiModelProperty(value = "user balance", example = "1.0F", required = true)
    private String password;

    @ApiModelProperty(value = "user email", example = "adventa@mail.ru", required = true)
    private String email;

    @ApiModelProperty(value = "user phone", example = "+79811715754", required = true)
    private String phone;

    @ApiModelProperty(value = "user address", example = "SPb, Demo street 25, 1, 12", required = true)
    private String address;

    @ApiModelProperty(value = "user balance", example = "1.0F", required = true)
    private Float balance;

    @ApiModelProperty(value = "list of roles")
    private Set<Role> roles;

    public UserDTO() {
    }


    public UserDTO(String userName, String password, Integer accessCode, String email, String phone, String address, Float balance, Set<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.accessCode = accessCode;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String login) {
        this.userName = userName;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

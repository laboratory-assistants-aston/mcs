package ru.aston.mcs.dto.request;


import ru.aston.mcs.entity.User;

import java.util.List;

public class RoleRequest {

    private String roleName;

    private List<User> users;

    public RoleRequest() {
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

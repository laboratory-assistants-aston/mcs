package ru.aston.mcs.dto.response;


import ru.aston.mcs.entity.User;

import java.util.List;

public class RoleResponse {

    private Long roleId;

    private String roleName;

    private List<User> users;

    public  RoleResponse(){}

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

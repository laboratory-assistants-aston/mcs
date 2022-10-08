package ru.aston.mcs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.aston.mcs.entity.User;

import java.util.List;

@ApiModel(value = "model for adding data in Roles table")
public class RolesDTO {
    private Long id;

    @ApiModelProperty(value = "name of role", example = "admin", required = true)
    private String roleName;

    @ApiModelProperty(value = "list of users with this role")
    private List<User> users;

    public RolesDTO() {
    }

    public RolesDTO(Long id, String roleName, List<User> users) {
        this.id = id;
        this.roleName = roleName;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

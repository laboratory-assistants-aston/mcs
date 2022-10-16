package ru.aston.mcs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.aston.mcs.entity.User;
import ru.aston.mcs.entity.enums.ERole;

import java.util.List;

@ApiModel(value = "model for adding data in Roles table")
public class RolesDTO {

    private Long id;

    @ApiModelProperty(value = "name of role", example = "admin", required = true)
    private ERole roleName;

    public RolesDTO(){}

    public RolesDTO(ERole roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getRoleName() {
        return roleName;
    }

    public void setRoleName(ERole roleName) {
        this.roleName = roleName;
    }
}

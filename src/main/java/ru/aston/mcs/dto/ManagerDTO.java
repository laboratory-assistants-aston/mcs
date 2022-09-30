package ru.aston.mcs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ManagerDTO {
    private int id;
    private String name;
    private String surname;
    private RoleDTO role;
    private List<ResourcesDTO> resourceList;
    private List<UsersDTO> userList;
    private String email;
}

package ru.aston.mcs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ManagerDTO {
    private int id;
    private String name;
    private String surname;
    private RoleDTO role;
    private List<ResourceDTO> resourceList;
    private List<UserDTO> userList;
    private String email;
}

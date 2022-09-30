package ru.aston.mcs.dto;

import lombok.*;
import ru.aston.mcs.entity.Role;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerDTO {
    private Long id;
    private String name;
    private String surname;
    private Role role;
    private List<ResourcesDTO> resourceList;
    private List<UsersDTO> userList;
    private String email;
}

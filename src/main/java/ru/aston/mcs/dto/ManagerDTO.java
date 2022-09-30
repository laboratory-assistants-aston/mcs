package ru.aston.mcs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.aston.mcs.entity.enums.Role;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDTO {
    private Long id;
    private String name;
    private String surname;
    private Role role;
    private List<ResourcesDTO> resourceList;
    private List<UsersDTO> userList;
    private String email;
}

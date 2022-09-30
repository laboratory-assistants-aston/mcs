package ru.aston.mcs.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.aston.mcs.entity.enums.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HousekeeperDTO {
    private Long id;
    private Role role;
    private String name;
    private String surname;
    private String email;
}

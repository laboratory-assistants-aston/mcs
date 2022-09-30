package ru.aston.mcs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.aston.mcs.entity.enums.Role;

@Data
//@Builder
@AllArgsConstructor
public class HousekeeperDTO {
    private int id;
    private Role role;
    private String name;
    private String surname;
    private String email;
}

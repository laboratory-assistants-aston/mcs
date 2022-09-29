package ru.aston.mcs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class HousekeeperDTO {
    private int id;
    private RoleDTO role;
    private String name;
    private String surname;
    private String email;
}

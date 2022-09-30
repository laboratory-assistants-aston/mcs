package ru.aston.mcs.dto;

import lombok.*;
import ru.aston.mcs.entity.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HousekeeperDTO {
    private Long id;
    private Role role;
    private String name;
    private String surname;
    private String email;
}

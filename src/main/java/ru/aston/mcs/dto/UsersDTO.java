package ru.aston.mcs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.aston.mcs.entity.GenderType;
import ru.aston.mcs.entity.Resource;
import ru.aston.mcs.entity.Role;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UsersDTO {
    private Long id;
    private GenderType gender;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String address;
    private String code;
    private List<Resource> resourceId;
    private UserPassportDataDTO passportId;
    private Role role;
}

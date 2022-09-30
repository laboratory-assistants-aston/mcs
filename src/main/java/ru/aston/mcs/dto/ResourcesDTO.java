package ru.aston.mcs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.aston.mcs.entity.enums.Status;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourcesDTO {
    private Long id;
    private Integer duringTime;
    private Status status;
    private TypeResourcesDTO nameId;
    private ResourceDetailsDTO detailsId;
    private UsersDTO usersId;
}

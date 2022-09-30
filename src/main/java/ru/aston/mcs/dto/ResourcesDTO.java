package ru.aston.mcs.dto;

import lombok.*;
import ru.aston.mcs.entity.Status;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class ResourcesDTO {
    private Long id;
    private Integer duringTime;
    private Status status;
    private TypeResourcesDTO nameId;
    private ResourceDetailsDTO detailsId;
    private UsersDTO usersId;
}

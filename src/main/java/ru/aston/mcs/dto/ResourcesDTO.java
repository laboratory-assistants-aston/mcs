package ru.aston.mcs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.aston.mcs.entity.enums.Status;

@Data
//@Builder
@AllArgsConstructor
public class ResourcesDTO {
    private Long id;
    private Integer duringTime;
    private Status status;
    private TypeResourcesDTO nameId;
    private ResourceDetailsDTO detailsId;
    private UsersDTO usersId;
}

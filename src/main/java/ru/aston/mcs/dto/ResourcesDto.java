package ru.aston.mcs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.aston.mcs.entity.Status;

@Data
@Builder
@AllArgsConstructor
public class ResourcesDto {
    private Long id;
    private Integer duringTime;
    private Status status;
    private TypeResourcesDto nameId;
    private DetailsResourcesDto detailsId;
    private UsersDto usersId;
}

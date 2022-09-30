package ru.aston.mcs.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResourceDetailsDTO {
    private Long detailsId;
    private Date startTime;
    private Date endTime;
    private String information;
}

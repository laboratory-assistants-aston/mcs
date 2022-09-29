package ru.aston.mcs.dto;


import lombok.Data;

import java.util.Date;

@Data
public class ResourceDetailsDTO {
    private Integer detailsId;
    private Date startTime;
    private Date endTime;
    private String information;
}

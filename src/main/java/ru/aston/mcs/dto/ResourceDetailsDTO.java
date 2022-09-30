package ru.aston.mcs.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDetailsDTO {
    private Long detailsId;
    private Date startTime;
    private Date endTime;
    private String information;
}

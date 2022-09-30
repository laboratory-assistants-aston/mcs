package ru.aston.mcs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
//@Builder
@AllArgsConstructor
public class UserPassportDataDTO {
    private String passportNumber;
    private String series;
    private Date expireDate;
    private String nationality;
    private Date birthDate;
}

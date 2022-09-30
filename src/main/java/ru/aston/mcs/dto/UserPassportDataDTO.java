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
public class UserPassportDataDTO {
    private String passportNumber;
    private String series;
    private Date expireDate;
    private String nationality;
    private Date birthDate;
}

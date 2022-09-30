package ru.aston.mcs.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPassportDataDTO {
    private String passportNumber;
    private String series;
    private Date expireDate;
    private String nationality;
    private Date birthDate;
}

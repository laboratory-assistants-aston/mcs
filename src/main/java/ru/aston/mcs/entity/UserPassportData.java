package ru.aston.mcs.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@AllArgsConstructor
public class UserPassportData {

    @Id
    @Column(name = "passport_number")
    private String passportNumber;

    @Column
    private String series;

    @Column(name = "expire_date")
    private Date expireDate;

    @Column
    private String nationality;

    @Column(name = "birth_date")
    private Date birthDate;

}

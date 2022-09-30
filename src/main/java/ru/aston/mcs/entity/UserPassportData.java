package ru.aston.mcs.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class UserPassportData {

    @Id
    @Column(name = "passport_number")
    @OneToOne(mappedBy = "passportId")
    private String passportNumber;

    @Column
    private String series;

    @Column(name = "expire_date")
    private Date expireDate;

    @Column
    private String nationality;

    @Column(name = "birth_date")
    private Date birthDate;

    public UserPassportData(String series, Date dateOfIssue, String nationality, Date birthDate) {
        this.series = series;
        this.expireDate = dateOfIssue;
        this.nationality = nationality;
        this.birthDate = birthDate;
    }
}

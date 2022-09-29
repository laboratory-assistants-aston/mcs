package ru.aston.mcs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
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

    public UserPassportData() {
    }

    public UserPassportData(String passportNumber, String series, Date dateOfIssue, String nationality, Date birthDate) {
        this.passportNumber = passportNumber;
        this.series = series;
        this.expireDate = dateOfIssue;
        this.nationality = nationality;
        this.birthDate = birthDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date dateOfIssue) {
        this.expireDate = dateOfIssue;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

package ru.aston.mcs.dto;

import java.util.Date;

public class ResidentPassportDTO {
    private String passportNumber;
    private String series;
    private Date expireDate;
    private String nationality;
    private Date birthDate;

    public ResidentPassportDTO() {
    }

    public ResidentPassportDTO(String passportNumber, String series, Date expireDate, String nationality, Date birthDate) {
        this.passportNumber = passportNumber;
        this.series = series;
        this.expireDate = expireDate;
        this.nationality = nationality;
        this.birthDate = birthDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
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

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
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
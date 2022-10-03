package ru.aston.mcs.entity;

import ru.aston.mcs.entity.enums.GenderType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "passports")
public class UserPassportData {

    @Id
    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "resident_id")
    private int residentId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "gender")
    private GenderType gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "registration_address")
    private String registrationAddress;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "expire_date")
    private Date expireDate;

    public UserPassportData() {
    }

    public UserPassportData(String passportNumber, int residentId, String name,
                            String surname, GenderType gender, Date birthDate,
                            String registrationAddress, String nationality, Date expireDate) {
        this.passportNumber = passportNumber;
        this.residentId = residentId;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.registrationAddress = registrationAddress;
        this.nationality = nationality;
        this.expireDate = expireDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getResidentId() {
        return residentId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
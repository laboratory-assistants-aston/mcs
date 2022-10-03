package ru.aston.mcs.entity;

import ru.aston.mcs.entity.enums.GenderType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "passports")
public class ResidentPassport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_number")
    private String passportNumber;

    //@MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id")
    private Resident residentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private GenderType gender;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "registration_address", nullable = false)
    private String registrationAddress;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "expire_date", nullable = false)
    private Date expireDate;

    public ResidentPassport() {
    }

    public ResidentPassport(String passportNumber, Resident residentId, String name,
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

    public Resident getResidentId() {
        return residentId;
    }

    public void setResidentId(Resident residentId) {
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
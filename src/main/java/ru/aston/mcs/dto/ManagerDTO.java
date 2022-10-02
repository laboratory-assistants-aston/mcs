package ru.aston.mcs.dto;

import ru.aston.mcs.entity.Person;

public class ManagerDTO {
    private Long id;
    private Person person;
    private String name;
    private String surname;
    private String jobTitle;

    public ManagerDTO() {
    }

    public ManagerDTO(Long id, Person person, String name, String surname, String jobTitle) {
        this.id = id;
        this.person = person;
        this.name = name;
        this.surname = surname;
        this.jobTitle = jobTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}

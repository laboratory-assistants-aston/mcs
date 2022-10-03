package ru.aston.mcs.entity;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "managers")
public class Manager {

    @Id
    @Column(name = "manager_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "surname", nullable = false)
    private String surname;

    public Manager() {
    }

    public Manager(Long id, User user, String name, String jobTitle, String surname) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.jobTitle = jobTitle;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getPerson() {
        return user;
    }

    public void setPerson(User person) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

package ru.aston.mcs.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="type_resources")
public class TypeResources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="name_id")
    private Integer nameId;

    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="cost", precision = 10, scale = 2)
    private Double cost;
}
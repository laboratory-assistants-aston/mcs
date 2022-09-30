package ru.aston.mcs.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "type_resources")
@AllArgsConstructor
public class TypeResources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name_id")
    private Long nameId;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "cost", precision = 10, scale = 2)
    private Double cost;
}
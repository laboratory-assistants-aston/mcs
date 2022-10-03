package ru.aston.mcs.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "resource_types")
public class ResourceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_type_id")
    private Long resourceTypeId;

    @Column(name = "resource_type_name", nullable = false)
    private String name;

    @Column(name = "resource_type_cost", nullable = false, precision = 10, scale = 2)
    private Double cost;

    public ResourceType(){}

    public ResourceType(Long resourceTypeId, String name, Double cost) {
        this.resourceTypeId = resourceTypeId;
        this.name = name;
        this.cost = cost;
    }

    public Long getNameId() {
        return resourceTypeId;
    }

    public void setNameId(Long nameId) {
        this.resourceTypeId = nameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
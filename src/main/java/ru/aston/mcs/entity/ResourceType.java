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
    private String resourceTypeName;

    @Column(name = "resource_type_cost", columnDefinition="Decimal(10,2) default '0.00'")
    private Double resourceTypeCost;

    public ResourceType() {
    }

    public Long getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Long resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }

    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    public Double getResourceTypeCost() {
        return resourceTypeCost;
    }

    public void setResourceTypeCost(Double resourceTypeCost) {
        this.resourceTypeCost = resourceTypeCost;
    }
}
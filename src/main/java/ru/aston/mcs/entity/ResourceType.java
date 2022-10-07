package ru.aston.mcs.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "resource_types")
public class ResourceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_type_id")
    private Long resourceTypeId;

    @Column(name = "resource_type_name", nullable = false)
    private String name;

    @Column(name = "resource_type_cost", columnDefinition = "Decimal(10,2) default '0.00'")
    private Double cost;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_type_id")
    private List<Resource> resourceList;

    public ResourceType() {
    }

    public ResourceType(Long resourceTypeId, String name, Double cost, List<Resource> resourceList) {
        this.resourceTypeId = resourceTypeId;
        this.name = name;
        this.cost = cost;
        this.resourceList = resourceList;
    }

    public Long getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Long resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
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

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
}
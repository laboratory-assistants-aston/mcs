package ru.aston.mcs.dto;

import ru.aston.mcs.entity.Resource;

import java.util.List;

public class ResourceTypeDTO {
    private Long resourceTypeId;
    private String name;
    private Double cost;
    private List<Resource> resourceList;

    public ResourceTypeDTO() {
    }

    public ResourceTypeDTO(Long resourceTypeId, String name, Double cost, List<Resource> resourceList) {
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
package ru.aston.mcs.dto;

public class ResourceTypeDTO {
    private Long resourceTypeId;
    private String name;
    private Double cost;

    public ResourceTypeDTO() {

    }

    public ResourceTypeDTO(Long resourceTypeId, String name, Double cost) {
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

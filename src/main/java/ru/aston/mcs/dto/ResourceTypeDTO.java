package ru.aston.mcs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "model for adding data in ResourceType table")
public class ResourceTypeDTO {

    private Long resourceTypeId;

    @ApiModelProperty(value = "name of type resource", example = "co-working", required = true)
    private String name;

    @ApiModelProperty(value = "cost of type resource", example = "100.00", required = true)
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

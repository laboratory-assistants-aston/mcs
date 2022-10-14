package ru.aston.mcs.dto.request;

public class ResourceTypeRequest {

    private String resourceTypeName;

    private Double resourceTypeCost;

    public ResourceTypeRequest() {
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

package ru.aston.mcs.dto.response;


public class ResourceTypeResponse {

    private Long resourceTypeId;

    private String resourceTypeName;

    private Double resourceTypeCost;

    public ResourceTypeResponse() {
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

package ru.aston.mcs.dto.response;


import ru.aston.mcs.entity.ResourceType;
import ru.aston.mcs.entity.Status;

public class ResourceResponse {

    private Long resourceId;

    private ResourceType resourceType;

    private Status status;

    private String resourceIdentifier;

    public ResourceResponse() {

    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResourceIdentifier() {
        return resourceIdentifier;
    }

    public void setResourceIdentifier(String resourceIdentifier) {
        this.resourceIdentifier = resourceIdentifier;
    }
}

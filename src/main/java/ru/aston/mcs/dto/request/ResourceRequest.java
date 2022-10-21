package ru.aston.mcs.dto.request;


import ru.aston.mcs.entity.ResourceType;
import ru.aston.mcs.entity.Status;

public class ResourceRequest {

    private ResourceType resourceType;

    private Status status;

    private String resourceIdentifier;

    public ResourceRequest() {

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

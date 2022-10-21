package ru.aston.mcs.entity;

import javax.persistence.*;

@Entity
@Table(name = "resource")
public class Resource {
    @Id
    @Column(name = "resources_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resource_type_id", nullable = false)
    private ResourceType resourceType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @Column(name = "resource_identifier", nullable = false)
    private String resourceIdentifier;


    public Resource() {
    }

    public Resource(Long resourceId, ResourceType resourceType, Status status, String resourceIdentifier) {
        this.resourceId = resourceId;
        this.resourceType = resourceType;
        this.status = status;
        this.resourceIdentifier = resourceIdentifier;
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

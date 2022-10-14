package ru.aston.mcs.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "resource")
public class Resource {
    @Id
    @Column(name = "resources_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_type_id", nullable = false)
    private ResourceType resourceType;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id")
    private List<BookingResource> bookingResourceList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @Column(name = "resource_identifier", nullable = false)
    private String resourceIdentifier;


    public Resource() {
    }

    public Resource(Long id, String resourceIdentifier, ResourceType resourceType, List<BookingResource> bookingResourceList) {
        this.resourceId = id;
        this.resourceIdentifier = resourceIdentifier;
        this.resourceType = resourceType;
        this.bookingResourceList = bookingResourceList;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long id) {
        this.resourceId = id;
    }

    public String getResourceIdentifier() {
        return resourceIdentifier;
    }

    public void setResourceIdentifier(String resourceIdentifier) {
        this.resourceIdentifier = resourceIdentifier;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public List<BookingResource> getBookingResourceList() {
        return bookingResourceList;
    }

    public void setBookingResourceList(List<BookingResource> bookingResourceList) {
        this.bookingResourceList = bookingResourceList;
    }
}

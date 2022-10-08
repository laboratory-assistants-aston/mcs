package ru.aston.mcs.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "resource")
public class Resource {
    @Id
    @Column(name = "resources_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resource_identifier")
    private int resourceIdentifier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_type_id", nullable = false)
    private ResourceType resourceType;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id")
    private List<BookingResource> bookingResourceList;

    public Resource() {
    }

    public Resource(Long id, int resourceIdentifier, ResourceType resourceType, List<BookingResource> bookingResourceList) {
        this.id = id;
        this.resourceIdentifier = resourceIdentifier;
        this.resourceType = resourceType;
        this.bookingResourceList = bookingResourceList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getResourceIdentifier() {
        return resourceIdentifier;
    }

    public void setResourceIdentifier(int resourceIdentifier) {
        this.resourceIdentifier = resourceIdentifier;
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

package ru.aston.mcs.dto;

import ru.aston.mcs.entity.BookingResource;
import ru.aston.mcs.entity.ResourceType;

import java.util.List;

public class ResourceDTO {
    private Long id;
    private int resourceIdentifier;
    private ResourceType resourceType;
    private List<BookingResource> bookingResourceList;

    public ResourceDTO() {
    }

    public ResourceDTO(Long id, int resourceIdentifier, ResourceType resourceType, List<BookingResource> bookingResourceList) {
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

package ru.aston.mcs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.aston.mcs.entity.BookingResource;
import ru.aston.mcs.entity.ResourceType;
import ru.aston.mcs.entity.Status;

import java.util.List;

@ApiModel(value = "model for adding data in resource table")
public class ResourceDTO {

    private Long id;

    @ApiModelProperty(value = "Identifier for resource", example = "1", required = true)
    private String resourceIdentifier;

    @ApiModelProperty(value = "Resource type id", example = "1", required = true)
    private ResourceType resourceType;

    @ApiModelProperty(value = "list of bookingResources", example = "1", required = true)
    private List<BookingResource> bookingResourceList;

    @ApiModelProperty(value = "id of type status", example = "LOCKED", required = true)
    private Status status;

    public ResourceDTO() {
    }

    public ResourceDTO(Long id, String resourceIdentifier, ResourceType resourceType, List<BookingResource> bookingResourceList) {
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

    public String getResourceIdentifier() {
        return resourceIdentifier;
    }

    public void setResourceIdentifier(String resourceIdentifier) {
        this.resourceIdentifier = resourceIdentifier;
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

    public List<BookingResource> getBookingResourceList() {
        return bookingResourceList;
    }

    public void setBookingResourceList(List<BookingResource> bookingResourceList) {
        this.bookingResourceList = bookingResourceList;
    }
}

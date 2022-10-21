package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.aston.mcs.dto.BookingResourceDTO;
import ru.aston.mcs.dto.ResponseBookingResourceDTO;
import ru.aston.mcs.entity.BookingResource;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingResourceMapper {
    BookingResource toModel(BookingResourceDTO bookingResourceDTO);

    BookingResourceDTO toDTO(BookingResource bookingResource);

    List<BookingResource> toModelList(List<BookingResourceDTO> bookingResourceDTOList);

    List<BookingResourceDTO> toDTOList(List<BookingResource> bookingResourceList);

    @Mapping(source = "resource.resourceId", target = "resource")
    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "status.statusId", target = "status")
    ResponseBookingResourceDTO toResponseDTO(BookingResource bookingResource);
}

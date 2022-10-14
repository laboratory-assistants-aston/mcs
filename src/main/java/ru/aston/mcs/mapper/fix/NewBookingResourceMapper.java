package ru.aston.mcs.mapper.fix;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.request.BookingResourceRequest;
import ru.aston.mcs.dto.response.BookingResourceResponse;
import ru.aston.mcs.entity.BookingResource;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewBookingResourceMapper {

    BookingResource toEntity(BookingResourceRequest bookingResourceRequest);

    BookingResourceResponse toResponse(BookingResource bookingResource);

    List<BookingResourceResponse> toResponseList(List<BookingResource> bookingResource);

}

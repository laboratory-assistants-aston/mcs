package ru.aston.mcs.service.fix;

import ru.aston.mcs.dto.request.BookingResourceRequest;
import ru.aston.mcs.dto.response.BookingResourceResponse;

import java.util.List;

public interface IBookingResourceService {

    List<BookingResourceResponse> getAll();

    BookingResourceResponse get(Long id);

    BookingResourceResponse create(BookingResourceRequest bookingResourceRequest);

    BookingResourceResponse update(Long id, BookingResourceRequest bookingResourceRequest);

    void delete(Long id);

}

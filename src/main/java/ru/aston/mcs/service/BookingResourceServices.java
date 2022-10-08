package ru.aston.mcs.service;

import ru.aston.mcs.dto.BookingResourceDTO;

import java.util.List;

public interface BookingResourceServices {

    List<BookingResourceDTO> getAllBookingResources();

    BookingResourceDTO getBookingResource(Long id);

    BookingResourceDTO createBookingResource(BookingResourceDTO resourceDto);

    BookingResourceDTO updateBookingResource(Long id, BookingResourceDTO resourceDTO);

    void deleteBookingResource(Long id);
}

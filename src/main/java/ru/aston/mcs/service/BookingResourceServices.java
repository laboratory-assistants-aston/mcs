package ru.aston.mcs.service;

import ru.aston.mcs.dto.BookingResourceDTO;
import ru.aston.mcs.dto.ResponseBookingResourceDTO;

import java.util.List;

public interface BookingResourceServices {

    List<BookingResourceDTO> getAllBookingResources();

    BookingResourceDTO getBookingResource(Long id);

    BookingResourceDTO createBookingResource(BookingResourceDTO resourceDto);

    BookingResourceDTO updateBookingResource(Long id, BookingResourceDTO resourceDTO);

    void deleteBookingResource(Long id);

    List<ResponseBookingResourceDTO> findAllBookingsByUserId(Long id);

    List<BookingResourceDTO> findAllBookingsByUserIdTest(Long id);

    void cancelBookingById(Long id);
}

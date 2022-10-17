package ru.aston.mcs.service;

import ru.aston.mcs.dto.BookingResourceResponseDTO;

import java.util.List;

public interface BookingResourceServices {

    List<BookingResourceResponseDTO> getAllBookingResources();

    BookingResourceResponseDTO getBookingResource(Long id);

    BookingResourceResponseDTO createBookingResource(BookingResourceResponseDTO resourceDto);

    BookingResourceResponseDTO updateBookingResource(Long id, BookingResourceResponseDTO resourceDTO);

    void deleteBookingResource(Long id);
}

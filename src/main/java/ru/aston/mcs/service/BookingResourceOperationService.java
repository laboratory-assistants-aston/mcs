package ru.aston.mcs.service;

import ru.aston.mcs.dto.BookingResourceRequestDTO;

public interface BookingResourceOperationService {
    void bookFreeResource(BookingResourceRequestDTO bookingResource, Long id);
}

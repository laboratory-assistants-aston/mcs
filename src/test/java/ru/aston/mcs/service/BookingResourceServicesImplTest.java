package ru.aston.mcs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.mcs.dto.BookingResourceResponseDTO;
import ru.aston.mcs.mapper.BookingResourceMapper;
import ru.aston.mcs.repository.BookingResourceRepository;
import ru.aston.mcs.service.impl.BookingResourceServicesImpl;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class BookingResourceServicesImplTest {
    @Mock
    private BookingResourceRepository bookingResourceRepository;

    @InjectMocks
    private BookingResourceServicesImpl bookingResourceServices;
    @Mock
    BookingResourceMapper bookingResourceMapper;

    private BookingResourceResponseDTO bookingResourceResponseDTO;

    @BeforeEach
    void createDto() {
        bookingResourceResponseDTO = new BookingResourceResponseDTO();
        bookingResourceResponseDTO.setId(0L);
        bookingResourceResponseDTO.setResource(null);
        bookingResourceResponseDTO.setStatus(null);
        bookingResourceResponseDTO.setDurationTime(0);
        bookingResourceResponseDTO.setEndBooking(new Date());
        bookingResourceResponseDTO.setStartBooking(new Date());
        bookingResourceResponseDTO.setUser(null);
    }

    @Test
    void getAllResourceTest() {
        bookingResourceServices.getAllBookingResources();
        Mockito.verify(bookingResourceRepository).findAll();
    }

    @Test
    void getResourceByIdTest() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> bookingResourceServices.getBookingResource(0L));
        Mockito.verify(bookingResourceRepository).findById(0L);
    }

    @Test
    void createResourceFromDtoTest() {
        bookingResourceServices.createBookingResource(bookingResourceResponseDTO);
        Mockito.verify(bookingResourceRepository).save(bookingResourceMapper.toModel(bookingResourceResponseDTO));
    }

    @Test
    void deleteResourceByIdTest() {
        bookingResourceServices.deleteBookingResource(1L);
        Mockito.verify(bookingResourceRepository).deleteById(1L);
    }
}
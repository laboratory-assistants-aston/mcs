package ru.aston.mcs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Profile;
import ru.aston.mcs.dto.BookingResourceDTO;
import ru.aston.mcs.mapper.BookingResourceMapper;
import ru.aston.mcs.repository.BookingResourceRepository;
import ru.aston.mcs.service.impl.BookingResourceServicesImpl;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@Profile("test")
class BookingResourceServicesImplTest {
    @Mock
    private BookingResourceRepository bookingResourceRepository;

    @InjectMocks
    private BookingResourceServicesImpl bookingResourceServices;
    @Mock
    BookingResourceMapper bookingResourceMapper;

    private BookingResourceDTO bookingResourceDTO;

    @BeforeEach
    void createDto() {
        bookingResourceDTO = new BookingResourceDTO();
        bookingResourceDTO.setId(0L);
        bookingResourceDTO.setResource(null);
        bookingResourceDTO.setStatus(null);
        bookingResourceDTO.setDurationTime(0);
        bookingResourceDTO.setEndBooking(new Date());
        bookingResourceDTO.setStartBooking(new Date());
        bookingResourceDTO.setUser(null);
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
        bookingResourceServices.createBookingResource(bookingResourceDTO);
        Mockito.verify(bookingResourceRepository).save(bookingResourceMapper.toModel(bookingResourceDTO));
    }

    @Test
    void deleteResourceByIdTest() {
        bookingResourceServices.deleteBookingResource(1L);
        Mockito.verify(bookingResourceRepository).deleteById(1L);
    }
}
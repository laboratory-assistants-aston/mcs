package ru.aston.mcs.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.aston.mcs.dto.BookingResourceDTO;
import ru.aston.mcs.mapper.BookingResourceMapper;
import ru.aston.mcs.repository.BookingResourceRepository;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class BookingResourceServicesImplTest {
    @Mock
    private BookingResourceRepository bookingResourceRepository;
    @Mock
    private BookingResourceMapper bookingResourceMapper;

    @InjectMocks
    private BookingResourceServicesImpl bookingResourceServices;

    private BookingResourceDTO bookingResourceDTO;

    @BeforeEach
    void createDto() {
        bookingResourceDTO = new BookingResourceDTO();
        bookingResourceDTO.setResourceType(null);
        bookingResourceDTO.setStatus(null);
        bookingResourceDTO.setDurationTime(0);
        bookingResourceDTO.setStartBooking(new Date());
        bookingResourceDTO.setEndBooking(new Date());
        bookingResourceDTO.setResidentList(null);
    }

    @Test
    void getAllBookingResourceTest() {
        bookingResourceServices.getAllBookingResources();
        Mockito.verify(bookingResourceRepository).findAll();
    }

    @Test
    void getBookingResourceByIdTest() {
        RuntimeException runtimeException =
                assertThrows(RuntimeException.class, () -> bookingResourceServices.getBookingResource(1L));
        Mockito.verify(bookingResourceRepository).findById(1L);
    }

    @Test
    void createBookingResourceFromDtoTest() {
        bookingResourceServices.addAndSaveBookingResource(bookingResourceDTO);
        Mockito.verify(bookingResourceRepository).save(bookingResourceMapper.toModel(bookingResourceDTO));
    }

    @Test
    void deleteBookingResourceByIdTest() {
        bookingResourceServices.deleteBookingResource(1L);
        Mockito.verify(bookingResourceRepository).deleteById(1L);
    }
}
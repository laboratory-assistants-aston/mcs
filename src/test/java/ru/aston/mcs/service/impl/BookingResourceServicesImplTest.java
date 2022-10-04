package ru.aston.mcs.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.mcs.dto.BookingResourceDTO;
import ru.aston.mcs.entity.BookingResource;
import ru.aston.mcs.mapper.BookingResourceMapper;
import ru.aston.mcs.repository.BookingResourceRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BookingResourceServicesImplTest {
    @Mock
    private BookingResourceRepository bookingResourceRepository;

    @InjectMocks
    private BookingResourceServicesImpl bookingResourceServices;

    private BookingResourceDTO bookingResourceDTO;
    @Mock
    private BookingResourceMapper bookingResourceMapper;

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
        List<BookingResource> bookingResourcesExpected = bookingResourceMapper
                .toModelList(Arrays.asList(bookingResourceDTO, bookingResourceDTO));
        Mockito.when(bookingResourceRepository.findAll()).thenReturn(bookingResourcesExpected);
        List<BookingResourceDTO> allBookingResourcesActual = bookingResourceServices.getAllBookingResources();
        Mockito.verify(bookingResourceRepository).findAll();
        assertEquals(bookingResourcesExpected.size(), allBookingResourcesActual.size());
    }

    @Test
    void getBookingResourceByIdTest() {
        BookingResource bookingResource = bookingResourceMapper.toModel(bookingResourceDTO);
        bookingResource.setId(2L);
        Mockito.when(bookingResourceRepository.findById(2L)).thenReturn(Optional.of(bookingResource));
        BookingResourceDTO bookingResourceActual = bookingResourceServices.getBookingResource(2L);
        Mockito.verify(bookingResourceRepository).findById(2L);
        assertEquals(bookingResource.getId(), bookingResourceActual.getId());
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
package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.BookingResourceDTO;
import ru.aston.mcs.entity.BookingResource;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.BookingResourceMapper;
import ru.aston.mcs.repository.BookingResourceRepository;
import ru.aston.mcs.service.BookingResourceServices;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingResourceServicesImpl implements BookingResourceServices {

    private final BookingResourceRepository bookingResourceRepository;

    private final BookingResourceMapper bookingResourceMapper;

    public BookingResourceServicesImpl(BookingResourceRepository bookingResourceRepository, BookingResourceMapper bookingResourceMapper) {
        this.bookingResourceRepository = bookingResourceRepository;
        this.bookingResourceMapper = bookingResourceMapper;
    }

    @Override
    public List<BookingResourceDTO> getAllBookingResources() {
        return bookingResourceMapper.toDTOList(bookingResourceRepository.findAll());
    }

    @Override
    public BookingResourceDTO getBookingResource(Long id) {

        return bookingResourceMapper.toDTO(
                bookingResourceRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public BookingResourceDTO createBookingResource(BookingResourceDTO resourceDto) {
        if (resourceDto == null) {
            throw new InvalidRequestException();
        }
        return bookingResourceMapper.toDTO(bookingResourceRepository.save(bookingResourceMapper.toModel(resourceDto)));
    }

    @Override
    public BookingResourceDTO updateBookingResource(Long id, BookingResourceDTO resourceDto) {
        if (resourceDto == null || id == null) {
            throw new InvalidRequestException();
        }
        BookingResource bookingResource = bookingResourceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        bookingResource.setId(resourceDto.getId());
        return bookingResourceMapper.toDTO(bookingResourceRepository.save(bookingResource));
    }

    @Override
    public void deleteBookingResource(Long id) {
        bookingResourceRepository.deleteById(id);
    }

}
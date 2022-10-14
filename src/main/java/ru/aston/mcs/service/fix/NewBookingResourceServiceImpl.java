package ru.aston.mcs.service.fix;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.request.BookingResourceRequest;
import ru.aston.mcs.dto.response.BookingResourceResponse;
import ru.aston.mcs.entity.BookingResource;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.fix.NewBookingResourceMapper;
import ru.aston.mcs.repository.BookingResourceRepository;

import java.util.List;

@Service
@Transactional
public class NewBookingResourceServiceImpl implements IBookingResourceService {

    private final BookingResourceRepository bookingResourceRepository;
    private final NewBookingResourceMapper bookingResourceMapper;

    public NewBookingResourceServiceImpl(BookingResourceRepository bookingResourceRepository, NewBookingResourceMapper bookingResourceMapper) {
        this.bookingResourceRepository = bookingResourceRepository;
        this.bookingResourceMapper = bookingResourceMapper;
    }

    @Override
    public List<BookingResourceResponse> getAll() {
        return  bookingResourceMapper.toResponseList(bookingResourceRepository.findAll());
    }

    @Override
    public BookingResourceResponse get(Long id) {
        return bookingResourceMapper.toResponse(
                bookingResourceRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public BookingResourceResponse create(BookingResourceRequest bookingResourceRequest) {
        if (bookingResourceRequest == null) {
            throw new InvalidRequestException();
        }
        return bookingResourceMapper.toResponse(
                bookingResourceRepository.save(
                        bookingResourceMapper.toEntity(bookingResourceRequest)));
    }

    @Override
    public BookingResourceResponse update(Long id, BookingResourceRequest bookingResourceRequest) {
        if (bookingResourceRequest == null || id == null) {
            throw new InvalidRequestException();
        }
        BookingResource bookingResource =
                bookingResourceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        bookingResource.setResource(bookingResourceRequest.getResource());
        bookingResource.setStatus(bookingResourceRequest.getStatus());
        bookingResource.setUser(bookingResourceRequest.getUser());
        bookingResource.setDurationTime(bookingResourceRequest.getDurationTime());
        bookingResource.setStartBooking(bookingResourceRequest.getStartBooking());
        bookingResource.setEndBooking(bookingResourceRequest.getEndBooking());


        return bookingResourceMapper.toResponse(bookingResourceRepository.save(bookingResource));
    }

    @Override
    public void delete(Long id) {
        bookingResourceRepository.deleteById(id);
    }

}

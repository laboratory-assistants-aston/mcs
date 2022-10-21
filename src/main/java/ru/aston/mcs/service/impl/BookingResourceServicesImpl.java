package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.BookingResourceDTO;
import ru.aston.mcs.dto.ResponseBookingResourceDTO;
import ru.aston.mcs.entity.BookingResource;
import ru.aston.mcs.entity.Status;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.BookingResourceMapper;
import ru.aston.mcs.repository.BookingResourceRepository;
import ru.aston.mcs.repository.StatusRepository;
import ru.aston.mcs.service.BookingResourceServices;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookingResourceServicesImpl implements BookingResourceServices {

    private final BookingResourceRepository bookingResourceRepository;
    private final StatusRepository statusRepository;

    private final BookingResourceMapper bookingResourceMapper;

    public BookingResourceServicesImpl(BookingResourceRepository bookingResourceRepository, StatusRepository statusRepository, BookingResourceMapper bookingResourceMapper) {
        this.bookingResourceRepository = bookingResourceRepository;
        this.statusRepository = statusRepository;
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

    @Override
    public List<ResponseBookingResourceDTO> findAllBookingsByUserId(Long id) {
        List<BookingResource> result = bookingResourceRepository.findBookingResourceByUser_Id(id);
        return result.stream().map(bookingResourceMapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public List<BookingResourceDTO> findAllBookingsByUserIdTest(Long id) {
        List<BookingResource> result = bookingResourceRepository.findBookingResourceByUser_Id(id);
        return result.stream().map(bookingResourceMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void cancelBookingById(Long id) {
        Optional<BookingResource> bookingResource = bookingResourceRepository.findById(id);
        if (bookingResource.isPresent()) {
            BookingResource result = bookingResource.get();
            //under id2 CANCEL status
            Status status = statusRepository.findById(2L).get();
            result.setStatus(status);
        }
    }
}
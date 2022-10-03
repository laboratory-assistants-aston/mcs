package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.BookingResourceDTO;
import ru.aston.mcs.mapper.BookingResourceMapper;
import ru.aston.mcs.repository.BookingResourceRepository;
import ru.aston.mcs.service.BookingResourceServices;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingResourceServicesImpl implements BookingResourceServices {

    private final BookingResourceRepository resourceRepository;

    private final BookingResourceMapper resourceMapper;

    public BookingResourceServicesImpl(BookingResourceRepository resourceRepository, BookingResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public List<BookingResourceDTO> getAllBookingResources() {
        return resourceMapper.toDTOList(resourceRepository.findAll());
    }

    @Override
    public BookingResourceDTO getBookingResource(Long id) {

        return resourceMapper.toDTO(
                resourceRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }


    @Override
    public void addAndSaveBookingResource(BookingResourceDTO resourceDto) {
        resourceRepository.save(
                resourceMapper.toModel(resourceDto));
    }

    @Override
    public void deleteBookingResource(Long id) {
        resourceRepository.deleteById(id);
    }

}
package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.BookingResourceRequestDTO;
import ru.aston.mcs.dto.BookingResourceResponseDTO;
import ru.aston.mcs.entity.BookingResource;
import ru.aston.mcs.entity.Resource;
import ru.aston.mcs.repository.ResourceRepository;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingResourceMapper {

    BookingResource toModel(BookingResourceResponseDTO bookingResourceResponseDTO);

    BookingResourceResponseDTO toDTO(BookingResource bookingResource);

    List<BookingResource> toModelList(List<BookingResourceResponseDTO> bookingResourceResponseDTOList);

    List<BookingResourceResponseDTO> toDTOList(List<BookingResource> bookingResourceList);

    BookingResource toRequestModel(BookingResourceRequestDTO bookingResourceRequestDTO);

    BookingResourceRequestDTO toRequestDTO(BookingResource bookingResource);

    List<BookingResource> toRequestModelList(List<BookingResourceRequestDTO> bookingResourceRequestDTOList);

    List<BookingResourceRequestDTO> toRequestDTOList(List<BookingResource> bookingResourceList);
}

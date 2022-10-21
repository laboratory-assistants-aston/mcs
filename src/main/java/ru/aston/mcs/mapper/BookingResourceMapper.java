package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.BookingResourceDTO;
import ru.aston.mcs.entity.BookingResource;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingResourceMapper {

    BookingResource toModel(BookingResourceDTO bookingResourceDTO);

    BookingResourceDTO toDTO(BookingResource bookingResource);

    List<BookingResource> toModelList(List<BookingResourceDTO> bookingResourceDTOList);

    List<BookingResourceDTO> toDTOList(List<BookingResource> bookingResourceList);
}

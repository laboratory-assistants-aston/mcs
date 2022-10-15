package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.BookingResource;

import java.util.List;

@Repository
public interface BookingResourceRepository extends JpaRepository<BookingResource, Long> {
    List<BookingResource> findBookingResourceByUser_Id(Long id);
}

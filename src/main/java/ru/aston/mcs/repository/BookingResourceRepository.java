package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.BookingResource;

@Repository
public interface BookingResourceRepository extends JpaRepository<BookingResource, Long> {
}

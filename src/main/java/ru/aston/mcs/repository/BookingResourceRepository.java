package ru.aston.mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.aston.mcs.entity.BookingResource;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingResourceRepository extends JpaRepository<BookingResource, Long> {

   //вызвать метод BookingResourceRepository для получения списка забронированных ресурсов за определенный день
    @Query(value = "select * from public.booking_resources " +
            "inner join public.status on booking_resources.status_id = status.status_id " +
            " inner join public.resource on booking_resources.resource_id = resource.resources_id " +
            " inner join public.resource_types on resource.resource_type_id = resource_types.resource_type_id " +
            " where status_name = 'ACTIVE' and resource.resource_type_id =:resourceTypeId " +
            "and booking_resources.start_booking between :startDay and :endDay",
            nativeQuery = true)
    List<BookingResource> findAllBookByResourceTypeAndStartBooking(Long resourceTypeId, LocalDateTime startDay, LocalDateTime endDay);

    //вызвать метод BookingResourceRepository для получения списка забронированных ресурсов за период
    @Query(value = "select * from public.booking_resources " +
            "inner join public.status on booking_resources.status_id = status.status_id " +
            " inner join public.resource on booking_resources.resource_id = resource.resources_id " +
            " inner join public.resource_types on resource.resource_type_id = resource_types.resource_type_id " +
            " where status_name = 'ACTIVE' and resource.resource_type_id =:resourceTypeId " +
            "and ( booking_resources.start_booking between :startDayMorning and :startDayEvening " +
            "or booking_resources.end_booking between :endDayMorning and :endDayEvening)",
            nativeQuery = true)
    List<BookingResource> findAllBookByResourceTypeAndStartBookingAndEndBooking(Long resourceTypeId, LocalDateTime startDayMorning, LocalDateTime startDayEvening, LocalDateTime endDayMorning, LocalDateTime endDayEvening);

}

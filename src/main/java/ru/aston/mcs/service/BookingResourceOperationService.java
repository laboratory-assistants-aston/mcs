package ru.aston.mcs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.response.ResourceResponse;
import ru.aston.mcs.entity.BookingResource;
import ru.aston.mcs.entity.Resource;
import ru.aston.mcs.entity.ResourceType;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.mapper.fix.NewBookingResourceMapper;
import ru.aston.mcs.mapper.fix.NewResourceMapper;
import ru.aston.mcs.mapper.fix.NewResourceTypeMapper;
import ru.aston.mcs.repository.BookingResourceRepository;
import ru.aston.mcs.repository.ResourceRepository;
import ru.aston.mcs.repository.ResourceTypeRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookingResourceOperationService {

    static final Logger log = LoggerFactory.getLogger(BookingResourceOperationService.class);

    private final ResourceRepository resourceRepository;
    private final BookingResourceRepository bookingResourceRepository;
    private final NewResourceMapper newResourceMapper;
    private final NewResourceTypeMapper newResourceTypeMapper;
    private final NewBookingResourceMapper bookingResourceMapper;
    private final ResourceTypeRepository resourceTypeRepository;

    public BookingResourceOperationService(ResourceRepository resourceRepository, BookingResourceRepository bookingResourceRepository, NewResourceMapper newResourceMapper, NewResourceTypeMapper newResourceTypeMapper, NewBookingResourceMapper bookingResourceMapper, ResourceTypeRepository resourceTypeRepository) {
        this.resourceRepository = resourceRepository;
        this.bookingResourceRepository = bookingResourceRepository;
        this.newResourceMapper = newResourceMapper;
        this.newResourceTypeMapper = newResourceTypeMapper;
        this.bookingResourceMapper = bookingResourceMapper;
        this.resourceTypeRepository = resourceTypeRepository;
    }

    public List<ResourceResponse> getAllFreeResourcesByStartAndByDuration(Long resourceTypeId, LocalDate startDate, LocalTime startTime, Integer durationTime) {

        //поиск ресурса
        ResourceType resourceTypeFromDb = resourceTypeRepository.findById(resourceTypeId)
                .orElseThrow(() -> new EntityNotFoundException(resourceTypeId));

        //определить значение текущего дня
        LocalDateTime startCurrentDay = LocalDateTime.of(LocalDate.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth()),
                LocalTime.of(00, 00, 00, 000000));
        LocalDateTime endCurrentDay = LocalDateTime.of(LocalDate.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth()),
                LocalTime.of(23, 59, 59, 000000));

        //список всех  забронированных ресурсов определенного на запрошенный день ???
        List<BookingResource> findBooks
                = bookingResourceRepository.findAllBookByResourceTypeAndStartBooking(resourceTypeId, startCurrentDay, endCurrentDay);

        //сформировать график из броней HashMap на целый день ключ -час, значение - List<Resource>
        HashMap<Integer, List<Resource>> bookingTimeTable = new HashMap<>();
        for (int i = 0; i <= 23; i++) {
            bookingTimeTable.put(i, new ArrayList<>());
        }

        // вытащить поле Resource,
        // получить значение часа localDateTime.getHour() - индекс таблицы
        // получить значение продолжительности ()
        // добавить в bookingTimetable (в промежутке с индекс по индекс+продолжительность)
        for (BookingResource book : findBooks) {
            int hourBook = book.getStartBooking().toLocalTime().getHour();
            int durationTimeBook = book.getDurationTime().intValue();
            for (int i = hourBook; i <= hourBook + durationTimeBook; i++) {
                List<Resource> resourcesFromBookingTimeTableForHour = bookingTimeTable.get(i);
                resourcesFromBookingTimeTableForHour.add(book.getResource());
                bookingTimeTable.put(i, resourcesFromBookingTimeTableForHour);
            }
        }
        bookingTimeTable.forEach((k, v) -> log.info("Key: " + k + " Value: " + v.toString()));

        int hourSearchingBook = startTime.getHour();
        int durationTimeSearchingBook = durationTime.intValue();
        //отфильтровать график по времени
        Map<Integer, List<Resource>> collect =
                bookingTimeTable.entrySet().stream()
                        .filter(x -> x.getKey() >= hourSearchingBook && x.getKey() <= hourSearchingBook + durationTimeSearchingBook && x.getValue().size() > 0)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        //сформировать список из забранированных
        List<Resource> bookingResourceBySearchingTime = new ArrayList<>();
        for (Map.Entry<Integer, List<Resource>> integerListEntry : collect.entrySet()) {
            List<Resource> value = integerListEntry.getValue();
            for (int i = 0; i < value.size(); i++) {
                bookingResourceBySearchingTime.add(value.get(i));
            }
        }
        //получить списко список всех ресурсов  определенного типа
        List<Resource> resourceByResourceType = resourceRepository.findAllResourceByResourceType(resourceTypeFromDb);

        //общего списка удалить те, что забронированы
        resourceByResourceType.removeAll(bookingResourceBySearchingTime);
        return newResourceMapper.toResponseList(resourceByResourceType);
    }

    // TODO добавить метод поиска по Date startBooking и Date endBooking
    public List<ResourceResponse> getAllFreeResourcesByStartBookingAndByEndBooking(Long resourceTypeId, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {

        ResourceType resourceTypeFromDb = resourceTypeRepository.findById(resourceTypeId)
                .orElseThrow(() -> new EntityNotFoundException(resourceTypeId));

        //определить значение текущего дня
        LocalDateTime startDayMorning = LocalDateTime.of(LocalDate.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth()),
                LocalTime.of(00, 00, 00, 000000));
        LocalDateTime startDayEvening = LocalDateTime.of(LocalDate.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth()),
                LocalTime.of(23, 59, 59, 000000));

        //определить значение текущего дня
        LocalDateTime endDateMorning = LocalDateTime.of(LocalDate.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth()),
                LocalTime.of(00, 00, 00, 000000));
        LocalDateTime endDateEvening = LocalDateTime.of(LocalDate.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth()),
                LocalTime.of(23, 59, 59, 000000));


        //список всех  забронированных ресурсов на запрошенный день ???
        List<BookingResource> findBooks
                = bookingResourceRepository.findAllBookByResourceTypeAndStartBookingAndEndBooking(resourceTypeId, startDayMorning, startDayEvening, endDateMorning, endDateEvening);

        //сформировать график из броней HashMap - календарь на целый день ключ -час, значение - List<Resource>
        Map<LocalDate, Map<Integer, List<Resource>>> bookingInPeriodTimeTable = new HashMap<>();
        int startDateDayOfMonth = startDate.getDayOfMonth();
        int endDateDayOfMonth = endDate.getDayOfMonth();
        for (int i = startDateDayOfMonth; i <= endDateDayOfMonth; i++) {
            HashMap<Integer, List<Resource>> bookingTimeTable = new HashMap<>();
            for (int j = 0; j <= 23; j++) {
                bookingTimeTable.put(j, new ArrayList<>());
            }
            LocalDate currentLocelDate = LocalDate.of(startDate.getYear(), startDate.getMonth(), i);
            bookingInPeriodTimeTable.put(currentLocelDate, bookingTimeTable);
        }
        bookingInPeriodTimeTable.forEach((k, v) -> log.info("Key: " + k + " Value: " + v.toString()));

        // вытащить поле Resource,
        // получить значение часа localDateTime.getHour() - индекс таблицы
        // получить значение продолжительности ()
        // добавить в bookingTimetable (в промежутке с индекс по индекс+продолжительность)
        for (BookingResource book : findBooks) {
            int startDayOfMonth = book.getStartBooking().toLocalDate().getDayOfMonth();
            log.info("startDayOfMonth: " + startDayOfMonth);
            int endDayOfMonth = book.getEndBooking().toLocalDate().getDayOfMonth();
            log.info("endDayOfMonth: " + endDayOfMonth);
            int startHourBook = book.getStartBooking().toLocalTime().getHour();
            log.info("startHourBook: " + startHourBook);
            int endHourBook = book.getStartBooking().toLocalTime().getHour();
            log.info("endHourBook: " + endHourBook);
            for (int i = startDayOfMonth; i <= endDayOfMonth; i++) {
                LocalDate currentBookDate = LocalDate.of(startDate.getYear(), startDate.getMonth(), i);
                log.info("currentBookDate: " + currentBookDate);
                Map<Integer, List<Resource>> bookingTimeTable = bookingInPeriodTimeTable.get(currentBookDate);
                for (int j = startHourBook; j <= endHourBook; j++) {
                    List<Resource> resourcesFromBookingTimeTableForHour = bookingTimeTable.get(j);
                    log.info("resourcesFromBookingTimeTableForHour: " + resourcesFromBookingTimeTableForHour);
                    resourcesFromBookingTimeTableForHour.add(book.getResource());
                    bookingTimeTable.put(j, resourcesFromBookingTimeTableForHour);
                }
            }
        }
        bookingInPeriodTimeTable.forEach((k, v) -> log.info("Key: " + k + " Value: " + v.toString() + v.entrySet().size()));

        int hourStartTime = startTime.getHour();
        int hourEndTime = endTime.getHour();
        List<List<Map.Entry<Integer, List<Resource>>>> collect = new ArrayList<>();
        //отфильтровать график по времени
        for (Map.Entry<LocalDate, Map<Integer, List<Resource>>> entry : bookingInPeriodTimeTable.entrySet()) {
            LocalDate key = entry.getKey();
            Map<Integer, List<Resource>> value = entry.getValue();

            collect.add(value.entrySet().stream()
                    .filter(bookingTimeTableValue -> bookingTimeTableValue.getKey() >= hourStartTime
                            && bookingTimeTableValue.getKey() <= hourEndTime
                            && bookingTimeTableValue.getValue().size() != 0)
                    .collect(Collectors.toList()));

        }
        //сформировать список из забранированных
        List<Resource> bookingResourceLists = new ArrayList<>();
        for (int i = 0; i < collect.size(); i++) {
            List<Map.Entry<Integer, List<Resource>>> entries = collect.get(i);
            if (entries.size() != 0) {
                for (int j = 0; j < entries.size(); j++) {
                    if (entries.size() != 0) {
                        for (Resource resource : entries.get(j).getValue()) {
                            bookingResourceLists.add(resource);
                        }
                    }
                }
            }
        }
        //получить списко список всех ресурсов  определенного типа
        List<Resource> resourceByResourceType = resourceRepository.findAllResourceByResourceType(resourceTypeFromDb);
        //общего списка удалить те, что забронированы
        resourceByResourceType.removeAll(bookingResourceLists);
        return newResourceMapper.toResponseList(resourceByResourceType);
    }
}

package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.mcs.dto.BookingResourceRequestDTO;
import ru.aston.mcs.entity.*;
import ru.aston.mcs.entity.enums.Operation;
import ru.aston.mcs.entity.enums.StatusName;
import ru.aston.mcs.exception.BalanceException;
import ru.aston.mcs.exception.StatusException;
import ru.aston.mcs.mapper.BookingResourceMapper;
import ru.aston.mcs.repository.*;
import ru.aston.mcs.service.BookingResourceOperationService;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;

@Service
@Transactional
public class BookingResourceOperationServiceImpl implements BookingResourceOperationService {

    ResourceRepository resourceRepository;
    UserRepository userRepository;
    BookingResourceRepository bookingResourceRepository;
    TransactionHistoryRepository transactionHistoryRepository;
    BookingResourceMapper bookingResourceMapper;
    StatusRepository statusRepository;

    public BookingResourceOperationServiceImpl(ResourceRepository resourceRepository,
                                               UserRepository userRepository,
                                               BookingResourceRepository bookingResourceRepository,
                                               TransactionHistoryRepository transactionHistoryRepository,
                                               BookingResourceMapper bookingResourceMapper,
                                               StatusRepository statusRepository) {
        this.resourceRepository = resourceRepository;
        this.userRepository = userRepository;
        this.bookingResourceRepository = bookingResourceRepository;
        this.transactionHistoryRepository = transactionHistoryRepository;
        this.bookingResourceMapper = bookingResourceMapper;
        this.statusRepository = statusRepository;
    }

    @Override
    public void bookFreeResource(BookingResourceRequestDTO bookingResourceDTO, Long id) {
        Long resourceId = bookingResourceDTO.getResourceId();
        Resource resource = resourceRepository.findById(resourceId).get();
        BookingResource bookingResource = bookingResourceMapper.toRequestModel(bookingResourceDTO);
        bookingResource.setResource(resource);

        double resourceCost = resource.getResourceType().getCost();
        StatusName resourceStatus = resource.getStatus().getStatus();
        double userBalance = userRepository.findUserById(1L).getBalance();

        if (userBalance >= resourceCost && resourceStatus.equals(StatusName.READY_TO_USE)){
            Status newResourceStatus = statusRepository.findById(resource.getStatus().getStatusId()).get();
            newResourceStatus.setStatus(StatusName.BOOKING);

            bookingResource.setStatus(newResourceStatus);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(bookingResource.getStartBooking());
            calendar.add(Calendar.DATE, bookingResource.getDurationTime());
            bookingResource.setEndBooking(calendar.getTime());
            bookingResource.setUser(userRepository.findUserById(1L));

            bookingResourceRepository.save(bookingResource);

            userRepository.findUserById(1L).setBalance(userBalance - resourceCost);

            TransactionHistory transactionHistory = new TransactionHistory(
                    userRepository.findUserById(1L),
                    userBalance - resourceCost,
                    Operation.DECREASE,
                    "booking resource: " + resource.getResourceId(),
                    new Date());

            transactionHistoryRepository.save(transactionHistory);

            User user = userRepository.findUserById(1L);
            user.setBalance(userBalance - resourceCost);
            userRepository.save(user);
        } else if (userBalance < resourceCost){
            throw new BalanceException();
        } else {
            throw new StatusException(resource.getResourceId());
        }
    }
}

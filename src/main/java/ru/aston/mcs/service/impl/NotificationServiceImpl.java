package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.NotificationResponseDTO;
import ru.aston.mcs.dto.NotificationsRequestDTO;
import ru.aston.mcs.entity.Notification;
import ru.aston.mcs.entity.User;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.NotificationMapper;
import ru.aston.mcs.repository.NotificationRepository;
import ru.aston.mcs.repository.UserRepository;
import ru.aston.mcs.service.NotificationService;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public NotificationServiceImpl(UserRepository userRepository, NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public List<NotificationResponseDTO> getAllNotifications() {
        return notificationMapper.toDTOResponseList(notificationRepository.findAll());
    }

    @Override
    public NotificationResponseDTO updateNotification(NotificationsRequestDTO notificationsRequestDTO) {
        if (notificationsRequestDTO == null || notificationsRequestDTO.getId() == null) {
            throw new InvalidRequestException();
        }
        Notification notificationFromDb = notificationRepository.findById(notificationsRequestDTO.getId())
                .orElseThrow(EntityNotFoundException::new);
        return initForNotification(notificationsRequestDTO, notificationFromDb);
    }

    @Override
    public void createNotification(NotificationsRequestDTO notificationsRequestDTO) {
        if (notificationsRequestDTO == null) {
            throw new InvalidRequestException();
        }
        initForNotification(notificationsRequestDTO, new Notification());
    }


    @Override
    public void deleteNotification(Long notificationId) {
        notificationRepository.deleteById(notificationId);
    }

    @Override
    public NotificationResponseDTO getNotification(Long notificationId) {
        return notificationMapper.toDTOResponse(
                notificationRepository.findById(notificationId)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public List<NotificationResponseDTO> getAllNotificationsByUserId(Long userId) {
        List<Notification> notifications = notificationRepository.findNotificationsByUser_Id(userId);
        return notificationMapper.toDTOResponseList(notifications);
    }

    @Override
    public NotificationResponseDTO getLastNotificationByUserId(Long userId) {
        List<Notification> notificationsByUserid = notificationRepository
                .findNotificationsByUser_Id(userId);
        return notificationMapper.toDTOResponse(notificationsByUserid.stream()
                .max(Comparator.comparing(Notification::getDate))
                .get());
    }

    @Override
    public void createNotificationAsList(NotificationsRequestDTO notificationsRequestDTO) {
        if (notificationsRequestDTO == null) {
            throw new InvalidRequestException();
        }
        initForNotification(notificationsRequestDTO, new Notification());
    }

    private NotificationResponseDTO initForNotification(NotificationsRequestDTO notificationsRequestDTO, Notification notificationFromDb) {
        List<User> collect = notificationsRequestDTO.getUserId()
                .stream()
                .map(userId -> {
                    User userFromDb = userRepository.findById(userId).get();
                    userFromDb.getNotificationList().add(notificationMapper.toModel(notificationsRequestDTO));
                    userRepository.save(userFromDb);
                    return userFromDb;
                }).collect(Collectors.toList());
        notificationFromDb.setUsers(collect);
        notificationFromDb.setText(notificationsRequestDTO.getText());
        notificationFromDb.setDate(notificationsRequestDTO.getDate());
        return notificationMapper.toDTOResponse(notificationRepository.save(notificationFromDb));
    }
}
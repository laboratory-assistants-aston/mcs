package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.NotificationDTO;
import ru.aston.mcs.entity.Notification;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.NotificationMapper;
import ru.aston.mcs.repository.NotificationRepository;
import ru.aston.mcs.service.NotificationService;


import java.util.List;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public NotificationServiceImpl(NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override

    public List<NotificationDTO> getAllNotifications() {
        return notificationMapper.toDTOList(notificationRepository.findAll());
    }

    @Override
    public NotificationDTO getNotification(Long notificationId) {
        return notificationMapper.toDTO(
                notificationRepository.findById(notificationId)
                        .orElseThrow( () -> new EntityNotFoundException(notificationId)));
    }

    @Override
    public NotificationDTO createNotification(NotificationDTO notificationDTO) {

        if (notificationDTO == null ) {
            throw new InvalidRequestException();
        }

        return notificationMapper.toDTO(
                notificationRepository.save(
                        notificationMapper.toModel(notificationDTO)));
    }



    @Override
    public NotificationDTO updateNotification(Long id, NotificationDTO notificationDTO) {
        if (notificationDTO == null || id == null) {
            throw new InvalidRequestException();
        }

        Long notificationId = notificationDTO.getNotificationId();
        Notification notificationFromDb = notificationRepository.findById(notificationId)
                .orElseThrow( () -> new EntityNotFoundException(notificationId));

        notificationFromDb.setUser(notificationDTO.getUser());
        notificationFromDb.setText(notificationDTO.getText());
        notificationFromDb.setDate(notificationDTO.getDate());

        return notificationMapper.toDTO(notificationRepository.save(notificationFromDb));
    }


    @Override
    public void deleteNotification(Long notificationId) {

        notificationRepository.deleteById(notificationId);
    }


}

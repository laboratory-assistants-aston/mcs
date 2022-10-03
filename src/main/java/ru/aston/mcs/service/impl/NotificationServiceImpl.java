package ru.aston.mcs.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.NotificationDTO;
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
    public void addAndSaveNotification(NotificationDTO notificationDTO) {

        notificationRepository.save(
                notificationMapper.toModel(notificationDTO));
    }

    @Override
    public void deleteNotification(Long notificationId) {
        notificationRepository.deleteById(notificationId);
    }

    @Override
    public NotificationDTO getNotification(Long notificationId) {
        return notificationMapper.toDTO(
                notificationRepository.findById(notificationId)
                        .orElseThrow(RuntimeException::new));
    }
}

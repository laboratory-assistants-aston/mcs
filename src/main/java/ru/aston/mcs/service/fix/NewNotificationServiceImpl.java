package ru.aston.mcs.service.fix;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.request.NotificationRequest;
import ru.aston.mcs.dto.response.NotificationResponse;
import ru.aston.mcs.entity.Notification;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.fix.NewNotificationMapper;
import ru.aston.mcs.repository.NotificationRepository;

import java.util.List;

@Service
@Transactional
public class NewNotificationServiceImpl implements INotificationService{

    private final NotificationRepository notificationRepository;
    private final NewNotificationMapper notificationMapper;


    public NewNotificationServiceImpl(NotificationRepository notificationRepository, NewNotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }


    @Override
    public List<NotificationResponse> getAll() {
        return  notificationMapper.toResponseList(notificationRepository.findAll());
    }

    @Override
    public NotificationResponse get(Long id) {
        return notificationMapper.toResponse(
                notificationRepository.findById(id)
                        .orElseThrow(RuntimeException::new));    }

    @Override
    public NotificationResponse create(NotificationRequest notificationRequest) {
        if (notificationRequest == null) {
            throw new InvalidRequestException();
        }
        return notificationMapper.toResponse(
                notificationRepository.save(
                        notificationMapper.toEntity(notificationRequest)));
    }

    @Override
    public NotificationResponse update(Long id, NotificationRequest notificationRequest) {

        if (notificationRequest == null || id == null) {
            throw new InvalidRequestException();
        }
        Notification notificationFromDb =
                notificationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        notificationFromDb.setText(notificationRequest.getText());
        notificationFromDb.setUser(notificationRequest.getUser());
        notificationFromDb.setCreationDate(notificationRequest.getCreationDate());

        return notificationMapper.toResponse(notificationRepository.save(notificationFromDb));
    }

    @Override
    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }
}

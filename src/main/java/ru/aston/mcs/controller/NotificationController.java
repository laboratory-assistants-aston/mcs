package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.NotificationDTO;
import ru.aston.mcs.entity.Notification;
import ru.aston.mcs.mapper.NotificationMapper;
import ru.aston.mcs.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private NotificationService notificationService;
    private NotificationMapper notificationMapper;

    public NotificationController(NotificationService notificationService, NotificationMapper notificationMapper) {
        this.notificationService = notificationService;
        this.notificationMapper = notificationMapper;
    }

    @GetMapping("/")
    public List<Notification> showAllNotifications(){

        List<Notification> allNotifications = notificationService.getAllNotifications();

        return allNotifications;
    }

    @GetMapping("/{id}")
    public NotificationDTO getNotification(@PathVariable int id){

        Notification notification = notificationService.getNotification(id);

        return notificationMapper.notificationInNotificationDTO(notification);
    }

    @PostMapping("/")
    public NotificationDTO addNewNotification(@RequestBody NotificationDTO notificationDTO){

        Notification notification = notificationMapper.notificationDtoInNotification(notificationDTO);
        notificationService.saveNotification(notification);

        return notificationDTO;
    }

    @PutMapping("/")
    public NotificationDTO updateNotification(@RequestBody NotificationDTO notificationDTO){

        Notification notification = notificationMapper.notificationDtoInNotification(notificationDTO);
        notificationService.saveNotification(notification);

        return notificationDTO;
    }

    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable int id){

        notificationService.deleteNotification(id);

        return "Notification " + id + "was deleted";
    }
}

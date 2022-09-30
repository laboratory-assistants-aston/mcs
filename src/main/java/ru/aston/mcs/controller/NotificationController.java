package ru.aston.mcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.aston.mcs.dto.NotificationDTO;
import ru.aston.mcs.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/")
    public List<NotificationDTO> showAllNotifications() {

        return notificationService.getAllNotifications();
    }

    @GetMapping("/{id}")
    public NotificationDTO getNotification(@PathVariable Long id) {

        return notificationService.getNotification(id);
    }

    @PostMapping("/")
    public void addNewNotification(@RequestBody NotificationDTO notificationDTO) {

        notificationService.addAndSaveNotification(notificationDTO);
        ;
    }

    @PutMapping("/")
    public void updateNotification(@RequestBody NotificationDTO notificationDTO) {
        notificationService.addAndSaveNotification(notificationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id) {

        notificationService.deleteNotification(id);
    }
}

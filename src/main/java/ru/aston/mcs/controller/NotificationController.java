package ru.aston.mcs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(basePath = "/api/notifications", value = "notifications", description = "Operations with notifications", produces = "application/json")
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @ApiOperation(value = "Create new notification")
    @GetMapping("/")
    public List<NotificationDTO> showAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @ApiOperation(value = "Get notification")
    @GetMapping("/{id}")
    public NotificationDTO getNotification(@PathVariable Long id) {
        return notificationService.getNotification(id);
    }

    @ApiOperation(value = "Add new notification")
    @PostMapping("/")
    public void addNewNotification(@RequestBody NotificationDTO notificationDTO) {
        notificationService.saveNotification(notificationDTO);
    }

    @ApiOperation(value = "Update  notification")
    @PutMapping("/")
    public NotificationDTO updateNotification(@RequestBody NotificationDTO notificationDTO) {
        return notificationService.updateNotification(notificationDTO);
    }

    @ApiOperation(value = "Delete notification")
    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
    }
}

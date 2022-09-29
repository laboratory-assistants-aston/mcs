package ru.aston.mcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.entity.Notification;
import ru.aston.mcs.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/")
    public List<Notification> showAllNotifications(){

        List<Notification> allNotifications = notificationService.getAllNotifications();

        return allNotifications;
    }

    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable int id){

        Notification notification = notificationService.getNotification(id);

        return notification;
    }

    @PostMapping("/")
    public Notification addNewNotification(@RequestBody Notification notification){

        notificationService.saveNotification(notification);

        return notification;
    }

    @PutMapping("/")
    public Notification updateNotification(@RequestBody Notification notification){

        notificationService.saveNotification(notification);

        return notification;
    }

    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable int id){

        notificationService.deleteNotification(id);

        return "Notification " + id + "was deleted";
    }
}

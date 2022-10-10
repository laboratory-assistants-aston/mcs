package ru.aston.mcs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
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

    @ApiOperation(value = "Get notification list")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notifications founded")})
    @GetMapping("/")
    public List<NotificationDTO> showAllNotifications() {
        List<NotificationDTO> allNotifications = notificationService.getAllNotifications();
        return allNotifications;
    }

    @ApiOperation(value = "Get notification list by user id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notifications founded")})
    @GetMapping("/user/{id}")
    public List<NotificationDTO> showAllNotificationsByUserId(@PathVariable Long id) {
        List<NotificationDTO> allNotifications = notificationService.getAllNotificationsByUserId(id);
        return allNotifications;
    }

    @ApiOperation(value = "Get notification")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notification founded")})
    @GetMapping("/{id}")
    public NotificationDTO getNotification(@PathVariable Long id) {
        return notificationService.getNotification(id);
    }

    @ApiOperation(value = "Add new notification")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notification added")})
    @PostMapping("/")
    public void addNewNotification(@RequestBody NotificationDTO notificationDTO) {
        notificationService.createNotification(notificationDTO);
    }

    @ApiOperation(value = "Update  notification")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notification updated")})
    @PutMapping("/")
    public NotificationDTO updateNotification(@RequestBody NotificationDTO notificationDTO) {
        return notificationService.updateNotification(notificationDTO);
    }

    @ApiOperation(value = "Delete notification")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notification deleted")})
    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
    }
}

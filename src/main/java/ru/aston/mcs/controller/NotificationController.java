package ru.aston.mcs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import ru.aston.mcs.dto.NotificationResponseDTO;
import ru.aston.mcs.dto.NotificationsRequestDTO;
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
    public List<NotificationResponseDTO> showAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @ApiOperation(value = "Get notification list by user id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notifications founded")})
    @GetMapping("/user/{id}")
    public List<NotificationResponseDTO> showAllNotificationsByUserId(@PathVariable Long id) {
        List<NotificationResponseDTO> allNotifications = notificationService.getAllNotificationsByUserId(id);
        return allNotifications;
    }

    @ApiOperation(value = "Get notification")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notification founded")})
    @GetMapping("/{id}")
    public NotificationResponseDTO getNotification(@PathVariable Long id) {
        return notificationService.getNotification(id);
    }

    @ApiOperation(value = "Get last notification by user id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notification founded")})
    @GetMapping("/last/{id}")
    public NotificationResponseDTO getLastNotificationByUserId(@PathVariable Long id) {
        return notificationService.getLastNotificationByUserId(id);
    }

    @ApiOperation(value = "Add new notification")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notification added")})
    @PostMapping("/")
    public void addNewNotification(@RequestBody NotificationsRequestDTO notificationsRequestDTO) {
        notificationService.createNotification(notificationsRequestDTO);
    }

    @ApiOperation(value = "Add new notifications for list of user")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notification added")})
    @PostMapping("/list")
    public void addNewNotificationsAsList(@RequestBody NotificationsRequestDTO notificationsRequestDTO) {
        notificationService.createNotificationAsList(notificationsRequestDTO);
    }

    @ApiOperation(value = "Update  notification")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notification updated")})
    @PutMapping("/")
    public NotificationResponseDTO updateNotification(@RequestBody NotificationsRequestDTO notificationsRequestDTO) {
        return notificationService.updateNotification(notificationsRequestDTO);
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
package ru.aston.mcs.controller.fix;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.mcs.dto.request.NotificationRequest;
import ru.aston.mcs.dto.response.NotificationResponse;
import ru.aston.mcs.service.fix.INotificationService;

import java.util.List;

@Api(basePath = "api/v2/notifications", value = "notifications", description = "Operations with notifications", produces = "application/json")
@RestController
@RequestMapping("api/v2/notifications")
public class NewNotificationController {

    private final INotificationService notificationService;

    public NewNotificationController(INotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @ApiOperation(value = "Create new notification")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notifications founded") })
    @GetMapping("/")
    public List<NotificationResponse> showAllNotifications() {
        return notificationService.getAll();
    }

    @ApiOperation(value = "Get notification")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notification founded") })
    @GetMapping("/{id}")
    public NotificationResponse getNotification(@PathVariable Long id) {
        return notificationService.get(id);
    }

    @ApiOperation(value = "Add new notification")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notification added") })
    @PostMapping("/")
    public NotificationResponse createNotification(@RequestBody NotificationRequest notificationRequest) {
        return notificationService.create(notificationRequest);
    }

    @ApiOperation(value = "Update  notification")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notification updated") })
    @PutMapping("/{id}")
    public NotificationResponse updateNotification(@PathVariable Long id, @RequestBody  NotificationRequest notificationRequest) {
        return notificationService.update(id, notificationRequest);
    }

    @ApiOperation(value = "Delete notification")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 201, message = "Notification deleted") })
    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id) {
        notificationService.delete(id);
    }
}

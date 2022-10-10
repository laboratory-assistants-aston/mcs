package ru.aston.mcs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.aston.mcs.entity.User;

import java.util.Date;
import java.util.List;


@ApiModel(value = "Table which shows information about notification")
public class NotificationsRequestDTO {

    @ApiModelProperty(value = "Notification's text")
    private String text;

    @ApiModelProperty(value = "User who get notifications")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<User> userIdList;

    @ApiModelProperty(value = "Date when notification sends")
    private Date date;

    public NotificationsRequestDTO() {
    }

    public NotificationsRequestDTO(Long notificationId, String text, List<User> userIdList, Date date) {

        this.text = text;
        this.userIdList = userIdList;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<User> getUserIdList() {
        return userIdList;
    }

    public void setUser(List<User> userList) {
        this.userIdList = userList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
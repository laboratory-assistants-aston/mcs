package ru.aston.mcs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;


@ApiModel(value = "Table which shows information about notification")
public class NotificationsRequestDTO {

    private Long id;

    @ApiModelProperty(value = "Notification's text")
    private String text;

    @ApiModelProperty(value = "User who get notifications")
    private List<Long> user;

    @ApiModelProperty(value = "Date when notification sends")
    private Date date;

    public NotificationsRequestDTO() {
    }

    public NotificationsRequestDTO(Long id, String text, List<Long> user, Date date) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Long> getUserId() {
        return user;
    }

    public void setUser(List<Long> user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
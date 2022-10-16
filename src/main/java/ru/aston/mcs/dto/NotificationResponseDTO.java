package ru.aston.mcs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


@ApiModel(value = "Table which shows information about notification")
public class NotificationResponseDTO {

    private Long id;
    @ApiModelProperty(value = "Notification's text")
    private String text;

    @ApiModelProperty(value = "Date when notification sends")
    private Date date;

    public NotificationResponseDTO() {
    }

    public NotificationResponseDTO(Long id, String text, Date date) {
        this.id = id;
        this.text = text;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
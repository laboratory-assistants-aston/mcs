package ru.aston.mcs.dto.query;

import org.springframework.web.bind.annotation.RequestParam;
import ru.aston.mcs.dto.ResourceTypeDTO;
import ru.aston.mcs.dto.request.ResourceRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class SearchResourceForBook {

    private Long resourceTypeId;
    private LocalDate startDate;
    private LocalTime startTime;
    private Integer durationTime;


    public SearchResourceForBook() {
    }

    public Long getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Long resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public Integer getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Integer durationTime) {
        this.durationTime = durationTime;
    }
}

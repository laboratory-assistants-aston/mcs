package ru.aston.mcs.util;

import ru.aston.mcs.dto.StatusDTO;
import ru.aston.mcs.entity.Status;

import java.util.List;

/**
 * @author Victoria Zhirnova
 * @project mcs
 */

public class StatusDataUtils {
    public static StatusDTO createStatusDTO() {
         return new StatusDTO(1L, "BOOKING");
    }

    public static Status createStatusEntity() {
         return new Status(1L, "BOOKING");
    }

    public static List<Status> createStatusEntityList() {
        return  List.of(new Status(1L, "BOOKING"), new Status(2L, "READY_TO_USE"));
    }
    public static List<StatusDTO> createStatusDTOList() {
        return  List.of(new StatusDTO(1L, "BOOKING"), new StatusDTO(2L, "READY_TO_USE"));
    }
}

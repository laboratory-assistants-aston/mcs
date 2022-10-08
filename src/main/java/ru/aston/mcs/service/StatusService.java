package ru.aston.mcs.service;

import ru.aston.mcs.dto.StatusDTO;
import java.util.List;


public interface StatusService {
    List<StatusDTO> getAllStatus();

   StatusDTO getStatus(Long statusId);

    StatusDTO createStatus(StatusDTO statusDTO);

    StatusDTO updateStatus(Long statusId, StatusDTO statusDTO);

    void deleteStatus(Long id);
}

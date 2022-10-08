package ru.aston.mcs.service;

import ru.aston.mcs.dto.StatusDTO;
import java.util.List;


public interface StatusService {
    List<StatusDTO> getAllStatus();

   StatusDTO getStatus(Long id);

    void saveStatus(StatusDTO statusDTO);

    StatusDTO updateStatus(StatusDTO statusDTO);

    void deleteStatus(Long id);
}

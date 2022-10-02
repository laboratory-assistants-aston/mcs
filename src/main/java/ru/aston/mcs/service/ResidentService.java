package ru.aston.mcs.service;

import ru.aston.mcs.dto.ResidentDTO;

import java.util.List;

public interface ResidentService {
    List<ResidentDTO> getAllResident();

    ResidentDTO getResident(Long id);

    void createResident(ResidentDTO residentDTO);

    void deleteResident(Long id);
}

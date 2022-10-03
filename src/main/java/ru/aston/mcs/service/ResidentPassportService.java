package ru.aston.mcs.service;


import ru.aston.mcs.dto.ResidentPassportDTO;

import java.util.List;

public interface ResidentPassportService {
    List<ResidentPassportDTO> getAllUserPassportDatas();

    void addAndSaveUserPassportData(ResidentPassportDTO userPassportDataDTO);

    void deleteUserPassportData(String userPassportDataId);

    ResidentPassportDTO getUserPassportData(String userPassportDataId);
}

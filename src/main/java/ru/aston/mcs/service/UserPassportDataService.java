package ru.aston.mcs.service;


import ru.aston.mcs.dto.UserPassportDataDTO;

import java.util.List;

public interface UserPassportDataService {
    List<UserPassportDataDTO> getAllUserPassportDatas();

    void addAndSaveUserPassportData(UserPassportDataDTO userPassportDataDTO);

    void deleteUserPassportData(String userPassportDataId);

    UserPassportDataDTO getUserPassportData(String userPassportDataId);
}

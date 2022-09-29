package ru.aston.mcs.service;


import ru.aston.mcs.entity.UserPassportData;

import java.util.List;

public interface UserPassportDataService {
    List<UserPassportData> getAllUserPassportDatas();

    void saveUserPassportData(UserPassportData userPassportData);

    void deleteUserPassportData(String userPassportDataId);

    UserPassportData getUserPassportData(String userPassportDataId);
}

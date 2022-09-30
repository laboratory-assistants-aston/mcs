package ru.aston.mcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.entity.UserPassportData;
import ru.aston.mcs.repository.UserPassportDataRepository;
import ru.aston.mcs.service.UserPassportDataService;

import java.util.List;

@Service
public class UserPassportDataServiceImpl implements UserPassportDataService {

    @Autowired
    UserPassportDataRepository userPassportDataRepository;

    @Override
    @Transactional
    public List<UserPassportData> getAllUserPassportDatas() {
        return userPassportDataRepository.findAll();
    }

    @Override
    @Transactional
    public void saveUserPassportData(UserPassportData userPassportData) {
        userPassportDataRepository.save(userPassportData);
    }

    @Override
    @Transactional
    public void deleteUserPassportData(String userPassportDataId) {
        //   userPassportDataRepository.delete(userPassportDataId);
    }

    @Override
    @Transactional
    public UserPassportData getUserPassportData(String userPassportDataId) {
//        UserPassportData userPassportData = null;
//        Optional<UserPassportData> userPassportDataOptional = userPassportDataRepository.findById(userPassportDataId);
//
//        if (userPassportDataOptional.isPresent()){
//            userPassportData = userPassportDataOptional.get();
//        }

        //return userPassportData;
        return null;
    }
}

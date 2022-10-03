package ru.aston.mcs.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.UserPassportDataDTO;
import ru.aston.mcs.mapper.UserPassportDataMapper;
import ru.aston.mcs.repository.UserPassportDataRepository;
import ru.aston.mcs.service.UserPassportDataService;

import java.util.List;

@Service
@Transactional
public class UserPassportDataServiceImpl implements UserPassportDataService {

    private final UserPassportDataRepository userPassportDataRepository;

    private final UserPassportDataMapper userPassportDataMapper;

    public UserPassportDataServiceImpl(UserPassportDataRepository userPassportDataRepository, UserPassportDataMapper userPassportDataMapper) {
        this.userPassportDataRepository = userPassportDataRepository;
        this.userPassportDataMapper = userPassportDataMapper;
    }

    @Override
    public List<UserPassportDataDTO> getAllUserPassportDatas() {
        return userPassportDataMapper.toDTOList(
                userPassportDataRepository.findAll());
    }

    @Override
    public void addAndSaveUserPassportData(UserPassportDataDTO userPassportDataDTO) {
        userPassportDataRepository.save(
                userPassportDataMapper.toModel(userPassportDataDTO));
    }

    @Override
    public void deleteUserPassportData(String userPassportDataId) {
        userPassportDataRepository.deleteById(userPassportDataId);
    }

    @Override
    public UserPassportDataDTO getUserPassportData(String userPassportDataId) {
        return userPassportDataMapper.toDTO(
                userPassportDataRepository.findById(userPassportDataId)
                        .orElseThrow(RuntimeException::new));

    }
}

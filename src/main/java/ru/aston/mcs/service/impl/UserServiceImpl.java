package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.UserDTO;
import ru.aston.mcs.mapper.UserMapper;
import ru.aston.mcs.repository.UserRepository;
import ru.aston.mcs.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository personsRepository, UserMapper personsMapper) {
        this.userRepository = personsRepository;
        this.userMapper = personsMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.toDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO getUser(Long personId) {
        return userMapper.toDTO(
                userRepository.findById(personId)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public void addAndSaveUser(UserDTO userDTO) {
        userRepository.save(userMapper.toModel(userDTO));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

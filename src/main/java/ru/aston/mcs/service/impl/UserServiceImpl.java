package ru.aston.mcs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.UserDTO;
import ru.aston.mcs.entity.User;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.UserMapper;
import ru.aston.mcs.repository.UserRepository;
import ru.aston.mcs.service.UserService;

import javax.persistence.EntityNotFoundException;
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
    public UserDTO createUser(UserDTO userDTO) {
        userRepository.save(userMapper.toModel(userDTO));
        return userDTO;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        if (userDTO == null || id == null) {
            throw new InvalidRequestException();
        }

        User userFromDb = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        userFromDb.setAccessCode(userDTO.getAccessCode());
        userFromDb.setAddress(userDTO.getAddress());
        userFromDb.setPhone(userDTO.getPhone());
        userFromDb.setBalance(userDTO.getBalance());
        userFromDb.setLogin(userDTO.getLogin());
        userFromDb.setRoles(userDTO.getRoles());
        userFromDb.setEmail(userDTO.getEmail());

        User user = userRepository.save(userFromDb);
        UserDTO userDTOResult = userMapper.toDTO(user);

        return userDTOResult;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

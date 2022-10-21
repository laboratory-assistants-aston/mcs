package ru.aston.mcs.service.fix;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.mcs.dto.request.UserRequest;
import ru.aston.mcs.dto.response.UserResponse;
import ru.aston.mcs.entity.User;
import ru.aston.mcs.exception.EntityNotFoundException;
import ru.aston.mcs.exception.InvalidRequestException;
import ru.aston.mcs.mapper.fix.NewUserMapper;
import ru.aston.mcs.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class NewUserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final NewUserMapper newUserMapper;

    public NewUserServiceImpl(UserRepository userRepository, NewUserMapper newUserMapper) {
        this.userRepository = userRepository;
        this.newUserMapper = newUserMapper;
    }

    @Override
    public List<UserResponse> getAll() {
        return newUserMapper.toResponseList(userRepository.findAll());
    }

    @Override
    public UserResponse get(Long id) {
         return newUserMapper.toResponse(
                 userRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        if (userRequest == null) {
            throw new InvalidRequestException();
        }
        return newUserMapper.toResponse(
                userRepository.save(
                        newUserMapper.toEntity(userRequest)));
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {

        if (userRequest == null || id == null) {
            throw new InvalidRequestException();
        }
        User userFromDb =
                userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        userFromDb.setLogin(userRequest.getLogin());
        userFromDb.setEmail(userRequest.getEmail());
        userFromDb.setAccessCode(userRequest.getAccessCode());
        userFromDb.setPhone(userRequest.getPhone());
        userFromDb.setAddress(userRequest.getAddress());
        userFromDb.setRoles(userRequest.getRoles());

        return newUserMapper.toResponse(userRepository.save(userFromDb));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

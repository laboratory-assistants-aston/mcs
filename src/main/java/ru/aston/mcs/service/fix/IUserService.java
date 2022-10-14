package ru.aston.mcs.service.fix;


import ru.aston.mcs.dto.request.UserRequest;
import ru.aston.mcs.dto.response.UserResponse;

import java.util.List;

public interface IUserService {

    List<UserResponse> getAll();

    UserResponse get(Long id);

    UserResponse create(UserRequest userRequest);

    UserResponse update(Long id, UserRequest userRequest);

    void delete(Long id);
}

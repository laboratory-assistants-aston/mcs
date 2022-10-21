package ru.aston.mcs.mapper.fix;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.request.UserRequest;
import ru.aston.mcs.dto.response.UserResponse;
import ru.aston.mcs.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewUserMapper {

    User toEntity(UserRequest userRequest);

    UserResponse toResponse(User user);

    List<UserResponse> toResponseList(List<User> userList);

}

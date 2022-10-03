package ru.aston.mcs.mapper;

import org.mapstruct.Mapper;
import ru.aston.mcs.dto.UserDTO;
import ru.aston.mcs.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toModel(UserDTO userDTO);

    UserDTO toDTO(User user);

    List<User> toModelList(List<UserDTO> userDTOList);

    List<UserDTO> toDTOList(List<User> userList);
}

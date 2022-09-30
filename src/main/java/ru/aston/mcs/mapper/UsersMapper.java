package ru.aston.mcs.mapper;


import org.mapstruct.Mapper;
import ru.aston.mcs.dto.UsersDTO;
import ru.aston.mcs.entity.Users;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    Users toModel(UsersDTO userDto);

    UsersDTO toDTO(Users user);

    List<Users> toModelList(List<UsersDTO> usersDTO);

    List<UsersDTO> toDTOList(List<Users> users);
}

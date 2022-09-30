package ru.aston.mcs.mapper;


import org.mapstruct.Mapper;
import ru.aston.mcs.dto.UsersDTO;
import ru.aston.mcs.entity.Users;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    Users usersDtoInUsers(UsersDTO userDto);

    UsersDTO usersInUsersDto(Users user);
}

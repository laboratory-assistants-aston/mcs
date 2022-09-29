package ru.aston.mcs.mapper;


import org.mapstruct.Mapper;
import ru.aston.mcs.dto.UsersDto;
import ru.aston.mcs.entity.Users;

@Mapper
public interface UsersMapper {
    Users usersDtoInUsers(UsersDto userDto);

    UsersDto usersInUsersDto(Users user);
}

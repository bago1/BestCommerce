package com.task.bestcommerce.mappers;

import com.task.bestcommerce.dto.UserDto;
import com.task.bestcommerce.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mapping(source = "numberOfSeats", target = "seatCount")
    User dtoToEntity(UserDto userDto);
    UserDto entityToDto(User user);
    List<User> dtoListToEntityList(List<UserDto> UserDtoList);
    List<UserDto> entityListToDtoList(List<User> UserList);
}

package com.example.rest.mapper;

import com.example.rest.dto.UserDto;
import com.example.rest.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER= Mappers.getMapper(AutoUserMapper.class);
    // this will provide implementations for this class at compile time


    UserDto mapToUser(User user);
    User mapToUserDto(UserDto user);


}

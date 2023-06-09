package com.example.rest.mapper;

import com.example.rest.dto.UserDto;
import com.example.rest.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    // this will provide implementations for this class at compile time


    User mapToUser(UserDto user);

    UserDto mapToUserDto(User user);


}

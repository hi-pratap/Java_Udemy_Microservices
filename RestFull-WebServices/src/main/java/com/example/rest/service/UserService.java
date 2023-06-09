    package com.example.rest.service;

    import com.example.rest.dto.UserDto;
    import com.example.rest.entity.User;

    import java.util.List;


    public interface UserService {

         UserDto createUser(UserDto user);

         UserDto updateUser(UserDto user);

        UserDto getUser(Long id);

        List<UserDto> getAllUsers();

        void deleteUser(Long id);


    }

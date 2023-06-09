    package com.example.rest.service;

    import com.example.rest.dto.UserDto;

    import java.util.List;


    public interface UserService {

         UserDto createUser(UserDto user);

         UserDto updateUser(UserDto user);

        UserDto getUserById(Long id);

        List<UserDto> getAllUsers();

        void deleteUser(Long id);


    }

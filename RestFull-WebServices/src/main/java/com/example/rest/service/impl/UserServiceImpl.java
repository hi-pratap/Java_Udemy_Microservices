package com.example.rest.service.impl;

import com.example.rest.dto.UserDto;
import com.example.rest.entity.User;
import com.example.rest.mapper.UserMapper;
import com.example.rest.repository.UserRepository;
import com.example.rest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto) {
        //convert userDto into JpaEntity
        User user = UserMapper.mapToUser(userDto);
        User savedUser=userRepository.save(user);
        // convert saved user to userDto
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto updateUser(UserDto user) {

        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);
        return  UserMapper.mapToUserDto(updatedUser);

    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        UserDto userDto = UserMapper.mapToUserDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> all = userRepository.findAll();
      return all.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

package com.example.rest.service.impl;

import com.example.rest.dto.UserDto;
import com.example.rest.entity.User;
import com.example.rest.exception.EmailAlreadyExistsException;
import com.example.rest.exception.ResourceNotFoundException;
import com.example.rest.mapper.AutoUserMapper;
import com.example.rest.repository.UserRepository;
import com.example.rest.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {
        //convert userDto into JpaEntity
        // User user = UserMapper.mapToUser(userDto);
        //User user = modelMapper.map(UserDto.class, User.class);
        Optional<User> byEmail = userRepository.findByEmail(userDto.getEmail());
        if (byEmail.isPresent()) {
            throw new EmailAlreadyExistsException("Email", userDto.getUsername(), userDto.getEmail());
        }

        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        // convert saved user to userDto
        //  UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        //UserDto savedUserDto = modelMapper.map(User.class, UserDto.class);
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto updateUser(UserDto user) {

        User existingUser = userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", user.getId()));
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);
        //  return UserMapper.mapToUserDto(updatedUser);
        // return modelMapper.map(User.class, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);

    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        //  UserDto userDto = UserMapper.mapToUserDto(user);
        //UserDto userDto =modelMapper.map(User.class, UserDto.class);;
        UserDto userDto = AutoUserMapper.MAPPER.mapToUserDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> all = userRepository.findAll();
        //   return all.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        //return all.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return all.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.deleteById(userId);
    }
}

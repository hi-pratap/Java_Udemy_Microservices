package com.example.rest.controller;

import com.example.rest.dto.UserDto;
import com.example.rest.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Tag(name = "Crud Rest point for User Resource", description = "User class")
public class UserController {

    private UserService userService;

    @Operation(summary = "Create- User rest api endpoint", description = "create a new user and save in database")
    @ApiResponse(responseCode = "200", description = "Http status  201 Created")
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Update- User rest api endpoint", description = "Update a new user and save in database")
    @ApiResponse(responseCode = "200", description = "Http status  201 Created")
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto user) {
        user.setId(id);
        UserDto userDto = userService.updateUser(user);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @Operation(summary = "Get- User rest api endpoint", description = "Get a new user and save in database")
    @ApiResponse(responseCode = "200", description = "Http status  201 Created")
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserByID(@PathVariable Long userId) {
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(summary = "GetAll- User rest api endpoint", description = "getAll a new user and save in database")
    @ApiResponse(responseCode = "200", description = "Http status  201 Created")
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> user = userService.getAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(summary = "Delete- User rest api endpoint", description = "Delete a new user and save in database")
    @ApiResponse(responseCode = "200", description = "Http status  201 Created")
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserByID(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(" User Deleted Successfully.", HttpStatus.OK);
    }

    //Exception specific to Controller Class
   /* @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> getErrorDetails(ResourceNotFoundException resourceNotFoundException, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                resourceNotFoundException.getMessage(),
                "User_NOT_FOUND",
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }*/
}

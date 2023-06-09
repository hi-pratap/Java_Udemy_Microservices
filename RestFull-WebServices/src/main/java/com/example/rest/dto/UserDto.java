package com.example.rest.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    private long id;

    private String username;

    private String password;

    private String email;
}

package com.example.rest.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "The User Dto Class"
)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    private long id;
    @Schema(
            description = "The User First Name"
    )
    @NotEmpty(message = "id is required")
    private String username;
    @Schema(
            description = "The User password "
    )
    @NotEmpty(message = "password is required")
    private String password;
    @Schema(
            description = "The User email "
    )
    @NotEmpty(message = "email is required")
    @Email
    private String email;
}

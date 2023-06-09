package com.example.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class EmailAlreadyExistsException extends RuntimeException  {

    private String email;
    private String username;
    private String userID;

    public EmailAlreadyExistsException(String email, String username, String userID){
        super(String.format("%s is already present for User %s with userId : %s", email, username,userID));
        this.email=email;
        this.username=username;
        this.userID=userID;
    }
}

package com.example.rest.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    // we are extending this class just to handle the exception made by the validation


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();

        allErrors.forEach((error) -> {
            String feildName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();

            errors.put(feildName, message);

        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> getErrorDetails(ResourceNotFoundException resourceNotFoundException, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), resourceNotFoundException.getMessage(), "User_NOT_FOUND", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleEmailErrorDetailsResponseEntityDetails(EmailAlreadyExistsException resourceNotFoundException, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), resourceNotFoundException.getMessage(), "Email Already Exists", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleExceptionDetails(Exception resourceNotFoundException, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), resourceNotFoundException.getMessage(), "Inteernal error occurred", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

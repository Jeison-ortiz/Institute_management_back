package org.projects.msvc_users.controller.ExceptionController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Date;

import org.projects.msvc_users.entity.models.Error;
import org.projects.msvc_users.exceptions.UserNotFoundException;

@ControllerAdvice
public class HandlerExceptionContoller {
    @ExceptionHandler({NoHandlerFoundException.class,
        NoResourceFoundException.class})
    public ResponseEntity<Error> notFoundException(Exception ex){
        Error error = new Error();
        error.setDate(new Date());
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

        @ExceptionHandler({NullPointerException.class,
        HttpMessageNotWritableException.class
    ,UserNotFoundException.class})
    public ResponseEntity<Error> userNotFoundException(Exception ex){
        Error error = new Error();
        error.setDate(new Date());
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
}

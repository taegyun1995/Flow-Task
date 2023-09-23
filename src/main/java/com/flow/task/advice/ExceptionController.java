package com.flow.task.advice;

import com.flow.task.advice.custom.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundUserException(NotFoundException businessException) {
        return ResponseEntity.status(NOT_FOUND).body(new ExceptionResponse(businessException.getExceptionCodeConst()));
    }

}
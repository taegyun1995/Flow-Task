package com.flow.task.advice;

import com.flow.task.advice.custom.AlreadyExistException;
import com.flow.task.advice.custom.ExceededException;
import com.flow.task.advice.custom.LengthRequiredException;
import com.flow.task.advice.custom.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundUserException(NotFoundException businessException) {
        return ResponseEntity.status(NOT_FOUND).body(new ExceptionResponse(businessException.getExceptionCodeConst()));
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundUserException(AlreadyExistException businessException) {
        return ResponseEntity.status(CONFLICT).body(new ExceptionResponse(businessException.getExceptionCodeConst()));
    }

    @ExceptionHandler(LengthRequiredException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundUserException(LengthRequiredException businessException) {
        return ResponseEntity.status(LENGTH_REQUIRED).body(new ExceptionResponse(businessException.getExceptionCodeConst()));
    }

    @ExceptionHandler(ExceededException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundUserException(ExceededException businessException) {
        return ResponseEntity.status(REQUESTED_RANGE_NOT_SATISFIABLE).body(new ExceptionResponse(businessException.getExceptionCodeConst()));
    }

}
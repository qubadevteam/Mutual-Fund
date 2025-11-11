package com.mutualfund.userservice.exception;

import com.mutualfund.commonentity.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseModel handleUserNotFoundException(UserNotFoundException e){
        return ResponseModel.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(e.getMessage())
                .data(null)
                .errors(e)
                .build();
    }
}

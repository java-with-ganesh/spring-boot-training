package com.i2i.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleRuntimeException(RuntimeException runtimeException) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, runtimeException.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public ProblemDetail handleException(Throwable throwable) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, throwable.getMessage());
    }
}

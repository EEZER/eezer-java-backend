package org.eezer.service.controller;

import javax.validation.ConstraintViolationException;

import org.eezer.service.domain.api.ErrorCodes;
import org.eezer.service.domain.api.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<Object> handleValidationError(RuntimeException ex, WebRequest request) {

        ErrorResponse response = ErrorResponse.builder()
                .success(false)
                .message(ErrorCodes.ValidationError.name())
                .message_extra(ex.getMessage())
                .build();

        return handleExceptionInternal(ex, response, new HttpHeaders(),
                HttpStatus.BAD_REQUEST, request);
    }

}
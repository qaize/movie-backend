package com.example.movies.controller;


import com.example.movies.dto.response.BaseResponseDTO;
import com.example.movies.exception.ProcessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(ProcessException.class)
    public ResponseEntity<? extends BaseResponseDTO> handleProcessException(ProcessException ex) {
        return buildResponseEntity(ex.getHttpStatus(),ex.getBaseResponseDTO());
    }

    private ResponseEntity<? extends BaseResponseDTO> buildResponseEntity(HttpStatus httpStatus, BaseResponseDTO responseDTO) {
        return new ResponseEntity<>(responseDTO, httpStatus);
    }

}

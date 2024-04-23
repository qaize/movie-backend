package com.example.movies.Controller;


import com.example.movies.DTO.Response.BaseResponseDTO;
import com.example.movies.Exception.ProcessException;
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

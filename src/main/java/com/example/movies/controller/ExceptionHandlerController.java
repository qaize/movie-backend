package com.example.movies.controller;


import com.example.movies.dto.BindingErrorDTO;
import com.example.movies.dto.response.BaseResponseDTO;
import com.example.movies.exception.ProcessException;
import com.example.movies.helper.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        List<BindingErrorDTO> listFieldErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> BindingErrorDTO.builder()
                        .property(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        .build()
                ).toList();

        return new ResponseEntity<>(ResponseHelper.failResponse("Request invalid",HttpStatus.BAD_REQUEST,listFieldErrors),HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ProcessException.class)
    public ResponseEntity<Object> handleProcessException(ProcessException ex) {
        return buildResponseEntity(ex.getHttpStatus(),ex.getBaseResponseDTO());
    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus httpStatus, BaseResponseDTO responseDTO) {
        return new ResponseEntity<>(responseDTO, httpStatus);
    }

}

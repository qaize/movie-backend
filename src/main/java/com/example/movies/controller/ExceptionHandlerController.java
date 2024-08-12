package com.example.movies.controller;


import com.example.movies.dto.BindingErrorDTO;
import com.example.movies.dto.response.BaseResponseDTO;
import com.example.movies.exception.ProcessException;
import com.example.movies.helper.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();

        Collection<BindingErrorDTO> listError = errors.stream().map(fieldError -> {

           String fieldName = ((FieldError) fieldError).getField();

           return BindingErrorDTO.builder()
                .property(fieldName)
                .message(fieldError.getDefaultMessage())
                .build();
        }
        ).collect(Collectors.toList());

        return new ResponseEntity<>(listError,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ProcessException.class)
    public ResponseEntity<? extends BaseResponseDTO> handleProcessException(ProcessException ex) {
        return buildResponseEntity(ex.getHttpStatus(),ex.getBaseResponseDTO());
    }

    private ResponseEntity<? extends BaseResponseDTO> buildResponseEntity(HttpStatus httpStatus, BaseResponseDTO responseDTO) {
        return new ResponseEntity<>(responseDTO, httpStatus);
    }

}

package com.example.movies.Helper;

import com.example.movies.DTO.BindingErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BindingHelper {

    public static ResponseEntity<Object> mapBindingErrors(BindingResult bindingResult) {
        List<FieldError>errorFields = bindingResult.getFieldErrors();

        Collection<BindingErrorDTO> listError = errorFields.stream().map(fieldError -> BindingErrorDTO.builder()
                .property(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build()).collect(Collectors.toList());

        return ResponseEntity.badRequest().body(listError);
    }
}

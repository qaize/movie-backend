package com.example.movies.helper;

import com.example.movies.dto.BindingErrorDTO;
import com.example.movies.dto.response.BaseResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BindingHelper {

    public static BaseResponseDTO<Object> mapBindingErrors(BindingResult bindingResult) {
        List<FieldError>errorFields = bindingResult.getFieldErrors();

        Collection<BindingErrorDTO> listError = errorFields.stream().map(fieldError -> BindingErrorDTO.builder()
                .property(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build()).collect(Collectors.toList());

        return ResponseHelper.failResponse("BAD REQUEST", HttpStatus.BAD_REQUEST,listError);
    }
}

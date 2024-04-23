package com.example.movies.Exception;


import com.example.movies.DTO.Response.BaseResponseDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class ProcessException extends RuntimeException {

    private BaseResponseDTO baseResponseDTO;
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public <T> ProcessException(String message) {
        generateResponse(message,null,null);
    }

    public <T> void generateResponse(String message, HttpStatus httpStatus, T result) {



        baseResponseDTO = new BaseResponseDTO<>();
        baseResponseDTO.setStatus(1);
        baseResponseDTO.setMessage(message);


        if (result != null) {
            baseResponseDTO.setData(result);
        }

        if(httpStatus != null){
            baseResponseDTO.setHttpStatus(httpStatus);
        }

    }

}

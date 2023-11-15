package com.example.movies.Helper;

import com.example.movies.DTO.Response.BaseResponseDTO;
import org.springframework.http.HttpStatus;

public class ResponseHelper {

    public static BaseResponseDTO<Object> successResponse(Object data,String message){
        return BaseResponseDTO.builder()
                .status(1)
                .httpStatus(HttpStatus.OK)
                .message(message)
                .data(data)
                .build();
    }

    public static BaseResponseDTO<Object> successResponseWithPaging(Object data, BaseResponseDTO.Paging paging,String message){
        return BaseResponseDTO.builder()
                .status(1)
                .httpStatus(HttpStatus.OK)
                .message(message)
                .data(data)
                .dataPaging(paging)
                .build();
    }
    public static BaseResponseDTO<Object> failResponse(String message){
        return BaseResponseDTO.builder()
                .status(0)
                .message(message)
                .build();
    }
}

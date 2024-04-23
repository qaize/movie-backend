package com.example.movies.Helper;

import com.example.movies.DTO.Response.BaseResponseDTO;
import org.springframework.http.HttpStatus;

public class ResponseHelper {

    public static BaseResponseDTO<Object> successResponse(Object data,String message){
        return BaseResponseDTO.builder()
                .status(0)
                .httpStatus(HttpStatus.OK)
                .message(message)
                .data(data)
                .build();
    }

    public static BaseResponseDTO<Object> successResponseWithPaging(Object data, BaseResponseDTO.Paging paging,String message){
        return BaseResponseDTO.builder()
                .status(0)
                .httpStatus(HttpStatus.OK)
                .message(message)
                .data(data)
                .paging(paging)
                .build();
    }
    public static BaseResponseDTO<Object> failResponse(String message){
        return BaseResponseDTO.builder()
                .status(1)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(message)
                .build();
    }

    public static BaseResponseDTO<Object> failResponse(String message,HttpStatus status){
        return BaseResponseDTO.builder()
                .status(1)
                .httpStatus(status)
                .message(message)
                .build();
    }

    public static BaseResponseDTO<Object> failResponse(String message,HttpStatus status,Object object){
        return BaseResponseDTO.builder()
                .status(1)
                .httpStatus(status)
                .message(message)
                .data(object)
                .build();
    }
}

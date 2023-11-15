package com.example.movies.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class BaseResponseDTO<T> {

    private Integer status;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private HttpStatus httpStatus;
    private String message;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Paging paging;

    @Builder
    public BaseResponseDTO(Integer status,String message,HttpStatus httpStatus,T data, Paging dataPaging) {
        this.status = status;
        this.message = message;
        this.httpStatus = httpStatus;
        this.data = data;
        this.paging = dataPaging;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Paging{
        private long totalData;
        private Integer totalPage;
        private Integer sizePerPage;
    }
}

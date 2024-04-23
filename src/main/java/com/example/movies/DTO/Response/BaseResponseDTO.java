package com.example.movies.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BaseResponseDTO<T> {

    private Integer status;
    private HttpStatus httpStatus;
    private String message;
    private T data;
    private Paging paging;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Paging{
        private long totalData;
        private Integer totalPage;
        private Integer sizePerPage;
    }
}

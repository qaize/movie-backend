package com.example.movies.Helper.PageMapper;

import com.example.movies.DTO.Response.BaseResponseDTO;
import org.springframework.data.domain.Page;

public class PageMapper {

    public static BaseResponseDTO.Paging constructPageBaseResponse(Page page){

        return BaseResponseDTO.Paging.builder()
                .totalPage(page.getTotalPages())
                .sizePerPage(page.getSize())
                .totalData(page.getTotalElements())
                .build();
    }
}

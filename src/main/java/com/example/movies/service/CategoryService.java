package com.example.movies.service;

import com.example.movies.dto.response.BaseResponseDTO;
import com.example.movies.entity.Categories;

public interface CategoryService {

    BaseResponseDTO<Object> getAllCategories();
    BaseResponseDTO<Object> insertCategories(Categories categories);
}

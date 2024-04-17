package com.example.movies.Service;

import com.example.movies.DTO.Response.BaseResponseDTO;
import com.example.movies.Entity.Categories;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriesService {

    ResponseEntity<Object> getAllCategories();
    ResponseEntity<Object> insertCategories(Categories categories);
}

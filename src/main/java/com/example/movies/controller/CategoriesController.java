package com.example.movies.controller;

import com.example.movies.dto.response.BaseResponseDTO;
import com.example.movies.entity.Categories;
import com.example.movies.helper.BindingHelper;
import com.example.movies.service.impl.CategoriesServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/categories")
@RequiredArgsConstructor
public class CategoriesController {

    private final CategoriesServiceImpl categoriesService;

    @GetMapping(value = "/get-all-categories")
    public BaseResponseDTO<Object> getAllCategory(){
        return  categoriesService.getAllCategories();
    }

    @PostMapping(value = "/insert")
    public BaseResponseDTO<Object> post(@Valid @RequestBody Categories categories, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            return categoriesService.insertCategories(categories);
        }
        return BindingHelper.mapBindingErrors(bindingResult);
    }
}

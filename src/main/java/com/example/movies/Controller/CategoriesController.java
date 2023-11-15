package com.example.movies.Controller;

import com.example.movies.DTO.Response.BaseResponseDTO;
import com.example.movies.Entity.Categories;
import com.example.movies.Helper.BindingHelper;
import com.example.movies.Service.Impl.CategoriesServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoriesController {

    @Autowired
    private CategoriesServiceImpl categoriesService;

    @GetMapping(value = "/get-all-categories")
    public ResponseEntity<Object> getAllCategory(){
        return  categoriesService.getAllCategories();
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Object> post(@Valid @RequestBody Categories categories, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            return categoriesService.insertCategories(categories);
        }
        return BindingHelper.mapBindingErrors(bindingResult);
    }
}

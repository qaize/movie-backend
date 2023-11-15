package com.example.movies.Service.Impl;

import com.example.movies.DAO.CategoriesRepository;
import com.example.movies.DTO.Response.BaseResponseDTO;
import com.example.movies.Entity.Categories;
import com.example.movies.Helper.ResponseHelper;
import com.example.movies.Service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.movies.Constanta.Constanta.SUCCESS_GET_ALL_CATEGORIES;
import static com.example.movies.Constanta.Constanta.SUCCESS_INSERT_CATEGORIES;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    private CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesServiceImpl(CategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public ResponseEntity<Object> getAllCategories(){
        try{
        List<Categories> categoriesList = categoriesRepository.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseHelper.successResponse(categoriesList,SUCCESS_GET_ALL_CATEGORIES));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ResponseHelper.failResponse(e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<Object> insertCategories(Categories categories) {
        try{
            categoriesRepository.save(categories);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseHelper.successResponse(categories,SUCCESS_INSERT_CATEGORIES));

        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ResponseHelper.failResponse(e.getMessage()));
        }
    }
}

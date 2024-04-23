package com.example.movies.Service.Impl;

import com.example.movies.DAO.CategoriesRepository;
import com.example.movies.DTO.Response.BaseResponseDTO;
import com.example.movies.Entity.Categories;
import com.example.movies.Exception.ProcessException;
import com.example.movies.Helper.ResponseHelper;
import com.example.movies.Service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.movies.Constanta.Constanta.SUCCESS_GET_ALL_CATEGORIES;
import static com.example.movies.Constanta.Constanta.SUCCESS_INSERT_CATEGORIES;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    private CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public BaseResponseDTO<Object> getAllCategories() {
        try {
            List<Categories> categoriesList = categoriesRepository.findAll();

            return ResponseHelper.successResponse(categoriesList, SUCCESS_GET_ALL_CATEGORIES);
        } catch (Exception e) {
            return ResponseHelper.failResponse(e.getMessage());
        }
    }

    @Override
    public BaseResponseDTO<Object> insertCategories(Categories categories) {


        Optional<Categories> data = categoriesRepository.findByCategory(categories.getCategory());

        if (data.isPresent()) {
            throw new ProcessException("Data already Registered");
        }

        categoriesRepository.save(categories);
        return ResponseHelper.successResponse(categories, SUCCESS_INSERT_CATEGORIES);

    }
}

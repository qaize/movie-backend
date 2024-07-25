package com.example.movies.service.impl;

import com.example.movies.dao.CategoriesRepository;
import com.example.movies.dto.response.BaseResponseDTO;
import com.example.movies.entity.Categories;
import com.example.movies.exception.ProcessException;
import com.example.movies.helper.ResponseHelper;
import com.example.movies.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.movies.constanta.Constanta.SUCCESS_GET_ALL_CATEGORIES;
import static com.example.movies.constanta.Constanta.SUCCESS_INSERT_CATEGORIES;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

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

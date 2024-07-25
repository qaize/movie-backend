package com.example.movies.service.impl;

import com.example.movies.dao.AuthorRepository;
import com.example.movies.dto.response.BaseResponseDTO;
import com.example.movies.entity.Author;
import com.example.movies.helper.ResponseHelper;
import com.example.movies.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.movies.constanta.Constanta.SUCCESS_GET_ALL_AUTHOR;
import static com.example.movies.constanta.Constanta.SUCCESS_INSERT_AUTHOR;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl (AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }


    @Override
    public BaseResponseDTO<Object> getAllAuthor() {
        try {
            var listAuthor = authorRepository.findAll();
            return ResponseHelper.successResponse(listAuthor,SUCCESS_GET_ALL_AUTHOR);
        }catch (Exception e){
            return ResponseHelper.failResponse(e.getMessage());
        }
    }

    @Override
    public BaseResponseDTO<Object> insertAuthor(Author author) {

        try {
            authorRepository.save(author);
            return ResponseHelper.successResponse(author,SUCCESS_INSERT_AUTHOR);
        }catch (Exception e){
            return ResponseHelper.failResponse(e.getMessage());
        }
    }
}

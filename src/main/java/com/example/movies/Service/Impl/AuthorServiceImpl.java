package com.example.movies.Service.Impl;

import com.example.movies.DAO.AuthorRepository;
import com.example.movies.Entity.Author;
import com.example.movies.Helper.ResponseHelper;
import com.example.movies.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.example.movies.Constanta.Constanta.SUCCESS_GET_ALL_AUTHOR;
import static com.example.movies.Constanta.Constanta.SUCCESS_INSERT_AUTHOR;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl (AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }


    @Override
    public ResponseEntity<Object> getAllAuthor() {
        try {
            var listAuthor = authorRepository.findAll();
            return ResponseEntity
                    .ok()
                    .body(ResponseHelper.successResponse(listAuthor,SUCCESS_GET_ALL_AUTHOR));
        }catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .body(ResponseHelper.failResponse(e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<Object> insertAuthor(Author author) {

        try {
            authorRepository.save(author);
            return ResponseEntity.ok().body(ResponseHelper.successResponse(author,SUCCESS_INSERT_AUTHOR));
        }catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .body(ResponseHelper.failResponse(e.getMessage()));
        }
    }
}

package com.example.movies.Service;

import com.example.movies.DTO.Response.BaseResponseDTO;
import com.example.movies.Entity.Author;
import org.springframework.http.ResponseEntity;

public interface AuthorService {

    BaseResponseDTO<Object> getAllAuthor();

    BaseResponseDTO<Object> insertAuthor(Author author);
}

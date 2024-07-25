package com.example.movies.service;

import com.example.movies.dto.response.BaseResponseDTO;
import com.example.movies.entity.Author;

public interface AuthorService {

    BaseResponseDTO<Object> getAllAuthor();

    BaseResponseDTO<Object> insertAuthor(Author author);
}

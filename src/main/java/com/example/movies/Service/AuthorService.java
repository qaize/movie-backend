package com.example.movies.Service;

import com.example.movies.Entity.Author;
import org.springframework.http.ResponseEntity;

public interface AuthorService {

    ResponseEntity<Object> getAllAuthor();

    ResponseEntity<Object> insertAuthor(Author author);
}

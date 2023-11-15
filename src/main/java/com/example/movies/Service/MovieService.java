package com.example.movies.Service;

import com.example.movies.Entity.Movie;
import org.springframework.http.ResponseEntity;

public interface MovieService {

    ResponseEntity<Object> getMovie(Integer page,Integer totalData);

    ResponseEntity<Object> insertMovie(Movie movie);
}

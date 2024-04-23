package com.example.movies.Service;

import com.example.movies.DTO.Response.BaseResponseDTO;
import com.example.movies.Entity.Movie;
import org.springframework.http.ResponseEntity;

public interface MovieService {

    BaseResponseDTO<Object> getMovie(Integer page, Integer totalData);

    BaseResponseDTO<Object> insertMovie(Movie movie);

    BaseResponseDTO<Object> getMovieBySearch(Integer movieId);

    BaseResponseDTO<Object> deleteUser(Integer movieId);
}

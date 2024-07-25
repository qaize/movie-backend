package com.example.movies.service;

import com.example.movies.dto.response.BaseResponseDTO;
import com.example.movies.entity.Movie;

public interface MovieService {

    BaseResponseDTO<Object> getMovie(Integer page, Integer totalData);

    BaseResponseDTO<Object> insertMovie(Movie movie);

    BaseResponseDTO<Object> getMovieBySearch(Integer movieId);

    BaseResponseDTO<Object> deleteUser(Integer movieId);
}

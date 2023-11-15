package com.example.movies.Service.Impl;


import com.example.movies.DAO.MovieRepository;
import com.example.movies.DTO.Response.BaseResponseDTO;
import com.example.movies.Entity.Movie;
import com.example.movies.Helper.ResponseHelper;
import com.example.movies.Service.MovieService;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.example.movies.Constanta.Constanta.*;

@Service
public class MovieServiceImpl implements MovieService {


    private final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public ResponseEntity<Object> getMovie(Integer page, Integer totalData) {
        try {

            Pageable pagination = PageRequest.of(page - 1, totalData, Sort.by("id").descending());
            Page<Movie> movieList = movieRepository.findAll(pagination);

            if (movieList.getContent().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, DATA_EMPTY);
            }
            BaseResponseDTO.Paging paging = new BaseResponseDTO.Paging(movieList.getTotalElements(), movieList.getTotalPages(), movieList.getSize());

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseHelper.successResponseWithPaging(movieList.getContent(), paging, SUCCESS_GET_MOVIE));

        } catch (ResponseStatusException ex) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseHelper.failResponse(ex.getReason()));

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ResponseHelper.failResponse(e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<Object> insertMovie(Movie movie) {
        try {
            movieRepository.save(movie);
            return ResponseEntity
                    .ok()
                    .body(ResponseHelper.successResponse(movie, SUCCESS_INSERT_MOVIE));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResponseEntity
                    .badRequest()
                    .body(ResponseHelper.failResponse(CONTACT_DEVELOPER));
        }
    }
}

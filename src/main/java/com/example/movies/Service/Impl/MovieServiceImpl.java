package com.example.movies.Service.Impl;


import com.example.movies.DAO.MovieRepository;
import com.example.movies.DTO.Response.BaseResponseDTO;
import com.example.movies.Entity.Movie;
import com.example.movies.Helper.PageMapper.PageMapper;
import com.example.movies.Helper.ResponseHelper;
import com.example.movies.Service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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
    public BaseResponseDTO<Object> getMovie(Integer page, Integer totalData) {
        try {

            Pageable pagination = PageRequest.of(page - 1, totalData, Sort.by("id").descending());
            Page movieList = movieRepository.findAllActiveMovie(pagination);

            if (movieList.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie list Empty");
            }

            BaseResponseDTO.Paging paging = PageMapper.constructPageBaseResponse(movieList);
            return ResponseHelper.successResponseWithPaging(movieList.getContent(), paging, SUCCESS_GET_MOVIE);
        } catch (ResponseStatusException ex) {
            return ResponseHelper.failResponse(ex.getReason());

        } catch (Exception e) {
            return ResponseHelper.failResponse(e.getMessage() != null ? e.getMessage() : "INTERNAL SERVER ERROR");
        }
    }

    @Override
    public BaseResponseDTO<Object> insertMovie(Movie movie) {
        try {
            movieRepository.save(movie);
            return ResponseHelper.successResponse(movie, SUCCESS_INSERT_MOVIE);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResponseHelper.failResponse(CONTACT_DEVELOPER);
        }
    }

    @Override
    public BaseResponseDTO<Object> getMovieBySearch(Integer movieId) {

        Optional<Movie> findMovie = movieRepository.findMovieByName(movieId);

        if(findMovie.isEmpty()){
            return ResponseHelper.failResponse("NOT FOUND");
        }

        return ResponseHelper.successResponse(findMovie, SUCCESS_GET_MOVIE);
    }

    @Override
    public BaseResponseDTO<Object> deleteUser(Integer movieId) {
        try {
            Movie data = movieRepository.findActiveMovieById(movieId);
            if(data == null){
                return ResponseHelper.failResponse("USER NOT FOUND OR DELETED",HttpStatus.BAD_REQUEST);
            }
            data.setIsActive(false);
            movieRepository.save(data);
            return ResponseHelper.successResponse(data, "SUCCESS DELETE MOVIE");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResponseHelper.failResponse("FAIL DELETE MOVIE");
        }

    }
}

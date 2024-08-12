package com.example.movies.controller;


import com.example.movies.dto.request.PaginationDTO;
import com.example.movies.dto.response.BaseResponseDTO;
import com.example.movies.dto.response.MovieDTO;
import com.example.movies.entity.Movie;
import com.example.movies.helper.BindingHelper;
import com.example.movies.service.impl.MovieServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieServiceImpl movieService;

    @PostMapping(value = "/all-movie")
    public BaseResponseDTO<Object> allMovie(@RequestBody PaginationDTO paginationDTO) {
        return movieService.getMovie(paginationDTO.getPage(), paginationDTO.getTotalData());
    }

    @PostMapping(path = "/get-movie")
    public BaseResponseDTO<Object> searchMovie(@Valid @RequestBody MovieDTO  movie) throws JsonProcessingException {
        return movieService.getMovieBySearch(movie.getId());
    }

    @PostMapping(value = "/insert")
    public BaseResponseDTO<Object> insert(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return movieService.insertMovie(movie);
        }
        return BindingHelper.mapBindingErrors(bindingResult);
    }

    @DeleteMapping(path = "/delete")
    public BaseResponseDTO<Object>delete(@RequestBody MovieDTO movie){
        return movieService.deleteUser(movie.getId());
    }
}

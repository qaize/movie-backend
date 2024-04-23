package com.example.movies.Controller;


import com.example.movies.DTO.Request.PaginationDTO;
import com.example.movies.DTO.Response.BaseResponseDTO;
import com.example.movies.DTO.Response.MovieDTO;
import com.example.movies.Entity.Movie;
import com.example.movies.Helper.BindingHelper;
import com.example.movies.Service.Impl.MovieServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/movie")
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping(value = "/all-movie")
    public BaseResponseDTO<Object> allMovie(@RequestBody PaginationDTO paginationDTO) {
        return movieService.getMovie(paginationDTO.getPage(), paginationDTO.getTotalData());
    }

    @PostMapping(path = "/get-movie")
    public BaseResponseDTO<Object> searchMovie(@RequestBody MovieDTO  movie) throws JsonProcessingException {
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

package com.example.movies.Controller;


import com.example.movies.DTO.Request.PaginationDTO;
import com.example.movies.Entity.Movie;
import com.example.movies.Helper.BindingHelper;
import com.example.movies.Service.Impl.MovieServiceImpl;
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

    @PostMapping(value = "/all-movie")
    public ResponseEntity<Object> allMovie(@RequestBody PaginationDTO paginationDTO) {
        return movieService.getMovie(paginationDTO.getPage(), paginationDTO.getTotalData());
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Object> insert(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return movieService.insertMovie(movie);
        }

        return BindingHelper.mapBindingErrors(bindingResult);
    }
}

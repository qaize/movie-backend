package com.example.movies.controller;


import com.example.movies.dto.response.BaseResponseDTO;
import com.example.movies.entity.Author;
import com.example.movies.helper.BindingHelper;
import com.example.movies.service.impl.AuthorServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorServiceImpl authorService;

    @GetMapping(path = "/get-all-author")
    public BaseResponseDTO<Object>getAllAuthor(){
        return authorService.getAllAuthor();
    }

    @PostMapping("/insert")
    public BaseResponseDTO<Object> insert(@Valid @RequestBody Author author, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            return authorService.insertAuthor(author);
        }
        return BindingHelper.mapBindingErrors(bindingResult);
    }
}

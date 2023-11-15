package com.example.movies.Controller;


import com.example.movies.Entity.Author;
import com.example.movies.Helper.BindingHelper;
import com.example.movies.Service.Impl.AuthorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/author")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;

    @GetMapping("/get-all-author")
    public ResponseEntity<Object>getAllAuthor(){
        return authorService.getAllAuthor();
    }

    @PostMapping("/insert")
    public ResponseEntity<Object>insert(@Valid @RequestBody Author author, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            return authorService.insertAuthor(author);
        }
        return BindingHelper.mapBindingErrors(bindingResult);
    }
}

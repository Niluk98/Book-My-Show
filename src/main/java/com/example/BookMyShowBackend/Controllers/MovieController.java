package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.DTO.MovieRequestDTO;
import com.example.BookMyShowBackend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public String addMovie(@RequestBody MovieRequestDTO movieRequestDTO){
        return movieService.createMovie(movieRequestDTO);
    }
}

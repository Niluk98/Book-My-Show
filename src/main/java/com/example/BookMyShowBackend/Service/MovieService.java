package com.example.BookMyShowBackend.Service;

import com.example.BookMyShowBackend.DTO.MovieRequestDTO;
import com.example.BookMyShowBackend.Model.MovieEntity;
import com.example.BookMyShowBackend.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public String createMovie(MovieRequestDTO movieRequestDTO){

        MovieEntity movieEntity=MovieEntity.builder().movieName(movieRequestDTO.getName()).duration(movieRequestDTO.getDuration()).releaseDate(movieRequestDTO.getReleaseDate()).build();

        try {
            movieRepository.save(movieEntity);
        }catch (Exception e){
            return "Error adding movie";
        }
        return "Movie added successfully";
    }
}

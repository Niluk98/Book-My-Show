package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

    MovieEntity findByMovieName(String movieName);
}

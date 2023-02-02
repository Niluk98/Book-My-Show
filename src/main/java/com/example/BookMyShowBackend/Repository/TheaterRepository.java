package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Model.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheatreEntity,Integer> {
}

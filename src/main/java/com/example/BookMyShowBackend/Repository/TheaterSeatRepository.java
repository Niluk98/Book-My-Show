package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Model.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatRepository extends JpaRepository<TheatreSeatEntity,Integer> {
}

package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Model.ShowEnitity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEnitity,Integer> {
}

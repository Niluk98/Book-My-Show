package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}

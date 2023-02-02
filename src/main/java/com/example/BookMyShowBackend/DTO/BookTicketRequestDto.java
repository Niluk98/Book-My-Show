package com.example.BookMyShowBackend.DTO;

import lombok.Data;

import java.util.List;
@Data
public class BookTicketRequestDto {

    List<String> requestedSeats;
    private int showId;
    private int userId;

}

package com.example.BookMyShowBackend.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowRequestDTO {
    LocalDate showDate;
    LocalTime showtime;
    String movieName;
    int theaterId;
}

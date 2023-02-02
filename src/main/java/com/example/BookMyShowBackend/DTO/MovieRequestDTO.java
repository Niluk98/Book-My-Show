package com.example.BookMyShowBackend.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class MovieRequestDTO {
    private String name;
    private Date releaseDate;
    private int duration;
}

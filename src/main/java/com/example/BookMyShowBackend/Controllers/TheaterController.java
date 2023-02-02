package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.DTO.TheaterRequestDTO;
import com.example.BookMyShowBackend.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;
    @PostMapping("/add")
    public String addTheater(@RequestBody TheaterRequestDTO theaterRequestDTO){

        return theaterService.createTheater(theaterRequestDTO);
    }
}

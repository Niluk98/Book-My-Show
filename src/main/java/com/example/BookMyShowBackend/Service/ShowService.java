package com.example.BookMyShowBackend.Service;

import com.example.BookMyShowBackend.DTO.ShowRequestDTO;
import com.example.BookMyShowBackend.Model.*;
import com.example.BookMyShowBackend.Repository.MovieRepository;
import com.example.BookMyShowBackend.Repository.ShowRepository;
import com.example.BookMyShowBackend.Repository.ShowSeatRepository;
import com.example.BookMyShowBackend.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ShowService {

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    ShowRepository showRepository;
   @Autowired
    MovieRepository movieRepository;
   @Autowired
   TheaterRepository theaterRepository;

    public String addShow(ShowRequestDTO showRequestDTO){

        //show entity
        ShowEnitity showEnitity=ShowEnitity.builder().showDate(showRequestDTO.getShowDate()).showTime(showRequestDTO.getShowtime()).build();

        //you need to get the movie repository
        MovieEntity movieEntity=movieRepository.findByMovieName(showRequestDTO.getMovieName());

        //you need to get the theater repository
        TheatreEntity theatreEntity =theaterRepository.findById(showRequestDTO.getTheaterId()).get();

        showEnitity.setTheatreEntity(theatreEntity);
        showEnitity.setMovies(movieEntity);

        //bcz we are doing a bidirectional mapping:
        //Optional things:

        movieEntity.getShowEntities().add(showEnitity);
        theatreEntity.getShowEnitities().add(showEnitity);

        List<ShowSeatEntity> seatEntityList =createShowSeats(theatreEntity.getTheatreSeatEntities());

         showEnitity.setListOfSeats(seatEntityList);
         //for each ShowSeat: we need to mark which particular show it belongs

        for(ShowSeatEntity showSeatEntity:seatEntityList){
            showSeatEntity.setShows(showEnitity);
        }
        movieRepository.save(movieEntity);
//        showRepository.save(showEnitity);
          theaterRepository.save(theatreEntity);

        return "Show added Successfully";







    }
    public List<ShowSeatEntity> createShowSeats(List<TheatreSeatEntity> theatreSeatEntityList){
        List<ShowSeatEntity> seats=new ArrayList<>();
        for(TheatreSeatEntity theatreSeatEntity:theatreSeatEntityList){
            ShowSeatEntity showSeatEntity= ShowSeatEntity.builder().seatType(theatreSeatEntity.getSeatType()).build();
            seats.add(showSeatEntity);
        }
        showSeatRepository.saveAll(seats);
        return seats;
    }
}

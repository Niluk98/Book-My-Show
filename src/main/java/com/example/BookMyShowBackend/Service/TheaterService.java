package com.example.BookMyShowBackend.Service;

import com.example.BookMyShowBackend.DTO.TheaterRequestDTO;
import com.example.BookMyShowBackend.Enum.SeatType;
import com.example.BookMyShowBackend.Model.TheatreEntity;
import com.example.BookMyShowBackend.Model.TheatreSeatEntity;
import com.example.BookMyShowBackend.Repository.TheaterRepository;
import com.example.BookMyShowBackend.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    TheaterSeatRepository theaterSeatRepository;
    @Autowired
    TheaterRepository theaterRepository;
    public  String createTheater(TheaterRequestDTO theaterRequestDTO){
        TheatreEntity theatreEntity=TheatreEntity.builder().name(theaterRequestDTO.getName()).address(theaterRequestDTO.getAddress()).city(theaterRequestDTO.getCity()).build();

        List<TheatreSeatEntity> theatreSeatEntityList=createTheaterSeats();
        theatreEntity.setTheatreSeatEntities(theatreSeatEntityList);

        //For each theater seat:we need to setTheatreEntity
        for(TheatreSeatEntity theatreSeatEntity:theatreSeatEntityList){
            theatreSeatEntity.setTheatreEntity(theatreEntity);
        }
        theaterRepository.save(theatreEntity);
        return "theater saved";

    }
    private List<TheatreSeatEntity> createTheaterSeats(){
        List<TheatreSeatEntity> seats=new ArrayList<>();

        TheatreSeatEntity theatreSeatEntity1=new TheatreSeatEntity("1A", SeatType.CLASSIC,100);
        TheatreSeatEntity theatreSeatEntity2=new TheatreSeatEntity("1B", SeatType.CLASSIC,100);
        TheatreSeatEntity theatreSeatEntity3=new TheatreSeatEntity("1C", SeatType.CLASSIC,100);
        TheatreSeatEntity theatreSeatEntity4=new TheatreSeatEntity("1D", SeatType.CLASSIC,100);
        TheatreSeatEntity theatreSeatEntity5=new TheatreSeatEntity("1E", SeatType.CLASSIC,100);
        TheatreSeatEntity theatreSeatEntity6=new TheatreSeatEntity("2A", SeatType.PLATINUM,100);
        TheatreSeatEntity theatreSeatEntity7=new TheatreSeatEntity("2B", SeatType.PLATINUM,100);
        TheatreSeatEntity theatreSeatEntity8=new TheatreSeatEntity("2C", SeatType.PLATINUM,100);
        TheatreSeatEntity theatreSeatEntity9=new TheatreSeatEntity("2D", SeatType.PLATINUM,100);
        TheatreSeatEntity theatreSeatEntity10=new TheatreSeatEntity("2E", SeatType.PLATINUM,100);
        seats.add(theatreSeatEntity1);
        seats.add(theatreSeatEntity2);
        seats.add(theatreSeatEntity3);
        seats.add(theatreSeatEntity4);
        seats.add(theatreSeatEntity5);
        seats.add(theatreSeatEntity6);
        seats.add(theatreSeatEntity7);
        seats.add(theatreSeatEntity8);
        seats.add(theatreSeatEntity9);
        seats.add(theatreSeatEntity10);
        theaterSeatRepository.saveAll(seats);
        return seats;

    }
}



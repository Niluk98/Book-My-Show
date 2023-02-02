package com.example.BookMyShowBackend.Service;

import com.example.BookMyShowBackend.DTO.BookTicketRequestDto;
import com.example.BookMyShowBackend.Model.ShowEnitity;
import com.example.BookMyShowBackend.Model.ShowSeatEntity;
import com.example.BookMyShowBackend.Model.TicketEntity;
import com.example.BookMyShowBackend.Model.User;
import com.example.BookMyShowBackend.Repository.ShowRepository;
import com.example.BookMyShowBackend.Repository.TicketRepository;
import com.example.BookMyShowBackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;

    public String bookTicket(BookTicketRequestDto bookTicketRequestDto) throws Exception{

        //get the requested seats;

        List<String> requestedSeats=bookTicketRequestDto.getRequestedSeats();
        ShowEnitity showEnitity=showRepository.findById(bookTicketRequestDto.getShowId()).get();
        User user=userRepository.findById(bookTicketRequestDto.getUserId()).get();

        //Get the showSeats
        List<ShowSeatEntity> showSeats=showEnitity.getListOfSeats();

        //Validate if seats available to the user

        List<ShowSeatEntity> bookedSeats=new ArrayList<>();

        for(ShowSeatEntity showSeat:showSeats){
            String seatNo= showSeat.getSeatNo();

            if(showSeat.isBooked()==false && requestedSeats.contains(seatNo)){

                bookedSeats.add(showSeat);
//                showSeat.setBooked(true);

            }


        }

        //failure
        if(bookedSeats.size()!=requestedSeats.size()){

            throw new Exception("Requested Seats not available");
        }

        //success
        TicketEntity ticketEntity=new TicketEntity();

        double multiplier=showEnitity.getMultiplier();
        String allotedSeats="";
        int rate=0;
        double totalAmount=0;
        for(ShowSeatEntity bookedSeat:bookedSeats){
            bookedSeat.setBooked(true);
            bookedSeat.setBookedAt(new Date());
            bookedSeat.setTicket(ticketEntity);
            bookedSeat.setShows(showEnitity);
            String seatNo=bookedSeat.getSeatNo();
            allotedSeats=allotedSeats+seatNo+",";

            if(bookedSeat.getSeatNo().contains("1")){
                rate=100;
            }else{
                rate=200;
            }
            totalAmount=totalAmount+multiplier*rate;

        }
        ticketEntity.setBooked_at(new Date());
        ticketEntity.setAmount((int) totalAmount);
        ticketEntity.setShow(showEnitity);
        ticketEntity.setUser(user);
        ticketEntity.setBookedSeats(bookedSeats);
        ticketEntity.setAllotedSeats(allotedSeats);

        //bidirectional mapping is pending..

        ticketRepository.save(ticketEntity);
        return "Successfully created Ticket";







    }
}

package com.example.BookMyShowBackend.Model;


import com.example.BookMyShowBackend.Enum.SeatType;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name="show_seats")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean booked;

    private double multiplier;

    private Date bookedAt;


    @ManyToOne
    @JoinColumn
    private ShowEnitity shows;

    @ManyToOne
    @JoinColumn
    private TicketEntity ticket;




}

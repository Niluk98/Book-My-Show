package com.example.BookMyShowBackend.Model;

import com.example.BookMyShowBackend.Enum.SeatType;
import javax.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

@Entity
@Table(name = "threatreSeat")
@Data
public class TheatreSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String SeatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private int rate;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatreEntity;

    public TheatreSeatEntity(String seatNo,SeatType seatType,int rate){
        this.SeatNo=seatNo;
        this.seatType=seatType;
        this.rate=rate;

    }
}

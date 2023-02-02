package com.example.BookMyShowBackend.Model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowEnitity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;

    private LocalTime showTime;

    private double multiplier;



    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date upatedOn;

    @ManyToOne
    @JoinColumn
    private MovieEntity movies;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatreEntity;

    @OneToMany(mappedBy = "shows",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> listOfSeats;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<TicketEntity> listOfTickets;
}

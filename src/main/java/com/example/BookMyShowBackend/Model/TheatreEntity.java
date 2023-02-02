package com.example.BookMyShowBackend.Model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "theater")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;

    private String city;

    private String address;

    //List of shows
    @OneToMany(mappedBy = "theatreEntity",cascade = CascadeType.ALL)
    private   List<TheatreSeatEntity> theatreSeatEntities;

    @OneToMany(mappedBy = "theatreEntity",cascade = CascadeType.ALL)
    private List<ShowEnitity> showEnitities;

}

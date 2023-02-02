package com.example.BookMyShowBackend.Model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Table(name  ="movies")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @Column(unique = true,nullable = false)
   private String movieName;

   private Date releaseDate;

   private int duration;

   @OneToMany(mappedBy = "movies",cascade = CascadeType.ALL)
    private  List<ShowEnitity> showEntities;
}

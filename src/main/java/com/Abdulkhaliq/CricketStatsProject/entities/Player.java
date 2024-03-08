package com.Abdulkhaliq.CricketStatsProject.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="player_details")
@Data
public class Player
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_Id",nullable = false)
    private int playerId;
    @Column(name = "playerName",nullable = false,length = 255)
    private String playerName;
    @Column(name = "playerDob",nullable = false,length = 255)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateOfBirth;
    @Column(name = "player_currentAge")
    private int playerAge;
    @Column(name = "countryName",nullable = false,length = 255)
    private String countryName;
    @Column(name="averageScore")
    private double AverageScore;
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Matches> matchesList=new ArrayList<>();
}

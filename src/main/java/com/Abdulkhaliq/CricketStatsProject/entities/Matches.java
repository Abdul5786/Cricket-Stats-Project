package com.Abdulkhaliq.CricketStatsProject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "matches")
@Data
public class Matches
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;
    @Column(name = "score",nullable = false)
    private Long score;
    @Column(name = "stadium_Name",nullable = false)
    private String stadium;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
}

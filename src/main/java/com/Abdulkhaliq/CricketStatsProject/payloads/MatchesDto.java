package com.Abdulkhaliq.CricketStatsProject.payloads;

import com.Abdulkhaliq.CricketStatsProject.entities.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchesDto
{
    private int matchId;
    private Long score;
    private String stadium;
}

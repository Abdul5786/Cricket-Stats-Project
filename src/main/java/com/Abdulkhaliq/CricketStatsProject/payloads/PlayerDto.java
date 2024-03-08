package com.Abdulkhaliq.CricketStatsProject.payloads;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto
{
    private int playerId;
    private String playerName;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateOfBirth;
    private int playerAge;
    private double AverageScore;
    private String countryName;
    private List<MatchesDto> matches;
}

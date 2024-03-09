package com.Abdulkhaliq.CricketStatsProject.controllers;


import com.Abdulkhaliq.CricketStatsProject.payloads.MatchesDto;
import com.Abdulkhaliq.CricketStatsProject.services.MatchServices;
import com.Abdulkhaliq.CricketStatsProject.services.PlayerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matches")
public class MatchesControllers
{
       @Autowired
       private MatchServices matchServices;

       @PostMapping(value = "/addPlayerMatches/{playerId}")
       public ResponseEntity<MatchesDto> addMatchesOfPlayers(@PathVariable Integer playerId, @RequestBody MatchesDto matchesDto)
       {
           MatchesDto matchesDto1 = matchServices.AddMatches(playerId, matchesDto);
           return new ResponseEntity<>(matchesDto1, HttpStatus.CREATED);
       }
}

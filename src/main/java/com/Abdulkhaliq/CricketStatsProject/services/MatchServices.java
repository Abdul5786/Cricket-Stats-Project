package com.Abdulkhaliq.CricketStatsProject.services;

import com.Abdulkhaliq.CricketStatsProject.payloads.MatchesDto;

public interface MatchServices
{
    MatchesDto AddMatches(Integer playerId,MatchesDto matchesDto);

}

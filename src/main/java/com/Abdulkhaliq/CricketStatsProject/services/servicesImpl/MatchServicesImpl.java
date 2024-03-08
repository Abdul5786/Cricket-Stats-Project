package com.Abdulkhaliq.CricketStatsProject.services.servicesImpl;

import com.Abdulkhaliq.CricketStatsProject.entities.Matches;
import com.Abdulkhaliq.CricketStatsProject.entities.Player;
import com.Abdulkhaliq.CricketStatsProject.exceptions.ResourceNotFoundException;
import com.Abdulkhaliq.CricketStatsProject.payloads.MatchesDto;
import com.Abdulkhaliq.CricketStatsProject.payloads.PlayerDto;
import com.Abdulkhaliq.CricketStatsProject.repositories.MatchRepo;
import com.Abdulkhaliq.CricketStatsProject.repositories.PlayerRepo;
import com.Abdulkhaliq.CricketStatsProject.services.MatchServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServicesImpl implements MatchServices
{

    @Autowired
    private MatchRepo matchRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public MatchesDto AddMatches(Integer playerId, MatchesDto matchesDto)
    {
        Player player = playerRepo.findById(playerId).orElseThrow(() -> new ResourceNotFoundException("Player not found", "with Id :", playerId));
        Matches matches = this.modelMapper.map(matchesDto, Matches.class);
        matches.setPlayer(player); // adding player
        Matches save = matchRepo.save(matches);
        player.setAverageScore(calculateAverageScore(player));  // updating player AverageScore By No of matches he played.
        playerRepo.save(player);
        return this.modelMapper.map(save,MatchesDto.class);
    }


    private double calculateAverageScore(Player player)
    {
        List<Matches> matchesPlayed = player.getMatchesList();
        if(matchesPlayed.isEmpty())
        {
            return 0.0;
        }
        int totalScore=0;
        int totalMatches= matchesPlayed.size();  // total matches played by a player
        for(Matches matches: matchesPlayed)
        {
            totalScore+=matches.getScore();
        }

        return  (double)totalScore/totalMatches;
    }


}

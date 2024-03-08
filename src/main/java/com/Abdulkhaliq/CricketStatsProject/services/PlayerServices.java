package com.Abdulkhaliq.CricketStatsProject.services;

import com.Abdulkhaliq.CricketStatsProject.payloads.PlayerDto;

import java.util.List;

public interface PlayerServices
{
    PlayerDto addPlayer(PlayerDto playerDto);
    PlayerDto updatePlayer(Integer playerId,PlayerDto playerDto);

    PlayerDto getPlayerById(Integer playerId);
    List<PlayerDto> getAllPlayerListWithAverageMoreThanX(Integer x,Integer pageNumber,Integer pageSize);

   String deletePlayerById(Integer playerId);

   List<PlayerDto> getPlayersByCountry(String countryName,Integer pageNumber,Integer pageSize);

   List<PlayerDto> listOfPlayerInSortedOrderWithAvgMoreThanY(Integer y, Integer pageNumber,Integer pageSize);
   // this method will first compare AvgScoreOfPlayer and if two player have same AvgScore then it will give priority to older one

}

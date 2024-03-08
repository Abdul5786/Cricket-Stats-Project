package com.Abdulkhaliq.CricketStatsProject.controllers;


import com.Abdulkhaliq.CricketStatsProject.config.AppConstants;
import com.Abdulkhaliq.CricketStatsProject.payloads.PlayerDto;
import com.Abdulkhaliq.CricketStatsProject.services.PlayerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerControllers
{
      @Autowired
      private PlayerServices playerServices;

      @PostMapping(value = "/addPlayer")
      public ResponseEntity<PlayerDto>  addPlayer(@RequestBody PlayerDto playerDto)
      {
          PlayerDto addedPlayer = playerServices.addPlayer(playerDto);
          return new ResponseEntity<>(addedPlayer, HttpStatus.CREATED);
      }

      @GetMapping(value = "/playerListAvgMoreThanX/{x}")
      public  ResponseEntity<List<PlayerDto>>   allPlayerListWithAverageMoreThanX
              (@PathVariable Integer x,
               @RequestParam(name = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
               @RequestParam(name ="pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false)  Integer pageSize)
      {
          List<PlayerDto> allPlayerListWithAverageMoreThanX = playerServices.getAllPlayerListWithAverageMoreThanX(x, pageNumber, pageSize);
          return ResponseEntity.ok(allPlayerListWithAverageMoreThanX);
      }

      @GetMapping(value = "/getPlayerByCountryName")
      public ResponseEntity<List<PlayerDto>> getPlayerListByCountry(@RequestParam(name = "countryName") String countryName,
                                                                    @RequestParam(name = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
                                                                    @RequestParam(name ="pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false)  Integer pageSize)
      {
          List<PlayerDto> playersByCountryName = playerServices.getPlayersByCountry(countryName, pageNumber, pageSize);
          return ResponseEntity.ok(playersByCountryName);
      }


       @GetMapping(value = "/getById/{playerId}")
       public  ResponseEntity<PlayerDto> getPlayerById(@PathVariable Integer playerId)
       {
           PlayerDto playerById = playerServices.getPlayerById(playerId);
           return ResponseEntity.ok(playerById);
       }
      public ResponseEntity<PlayerDto> updatePlayer(@PathVariable Integer playerId,@RequestBody PlayerDto playerDto)
      {
          PlayerDto updatedPlayer = playerServices.updatePlayer(playerId, playerDto);
          return ResponseEntity.ok(updatedPlayer);
      }

    @GetMapping(value = "/playerListAvgMoreThanY/{y}")
    public  ResponseEntity<List<PlayerDto>>   playerListWithAverageMoreThanYWithPriorities
            (@PathVariable Integer y,
             @RequestParam(name = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
             @RequestParam(name ="pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false)  Integer pageSize)
    {
        List<PlayerDto> playerDtos = playerServices.listOfPlayerInSortedOrderWithAvgMoreThanY(y, pageNumber, pageSize);
        return ResponseEntity.ok(playerDtos);
    }


}

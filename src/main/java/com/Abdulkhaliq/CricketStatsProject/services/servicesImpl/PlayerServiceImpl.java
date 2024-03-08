package com.Abdulkhaliq.CricketStatsProject.services.servicesImpl;

import com.Abdulkhaliq.CricketStatsProject.entities.Matches;
import com.Abdulkhaliq.CricketStatsProject.entities.Player;
import com.Abdulkhaliq.CricketStatsProject.exceptions.ResourceNotFoundException;
import com.Abdulkhaliq.CricketStatsProject.exceptions.ResponseMessageException;
import com.Abdulkhaliq.CricketStatsProject.payloads.PlayerDto;
import com.Abdulkhaliq.CricketStatsProject.repositories.PlayerRepo;
import com.Abdulkhaliq.CricketStatsProject.services.PlayerServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlayerServiceImpl implements PlayerServices
{
    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PlayerDto addPlayer(PlayerDto playerDto)
    {
        Player player = this.modelMapper.map(playerDto, Player.class);
        Player found= playerRepo.findByPlayerName(player.getPlayerName());
        if(found!=null)
        {
               throw new ResponseMessageException("player : " + player.getPlayerName() +  "    already exist");
        }
        int age = calculateAge(playerDto.getDateOfBirth());
        player.setPlayerAge(age); // setting player age from dob to current date
        Player save = playerRepo.save(player);  // saving data
        return this.modelMapper.map(save, PlayerDto.class);
    }

    @Override
    public PlayerDto updatePlayer(Integer playerId, PlayerDto playerDto)
    {
        Player player = playerRepo.findById(playerId).orElseThrow(() -> new ResourceNotFoundException("player with", "playerId", +playerId));
        player.setPlayerName(playerDto.getPlayerName());
        player.setCountryName(playerDto.getCountryName());
        player.setDateOfBirth(playerDto.getDateOfBirth());
        Player updatedPlayer = playerRepo.save(player);
        return this.modelMapper.map(updatedPlayer,PlayerDto.class);  // returning data into dtos
    }

    @Override
    public PlayerDto getPlayerById(Integer playerId)
    {
        Player player = playerRepo.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("player with", "playerId", +playerId));
        return this.modelMapper.map(player,PlayerDto.class);
    }

    @Override
    public List<PlayerDto> getAllPlayerListWithAverageMoreThanX(Integer x,Integer pageNumber,Integer pageSize)
    {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Player> allPlayerPage = playerRepo.findAll(pageRequest);
        List<Player> playerList = allPlayerPage.getContent();  // using Java8 method filter to get Player Who score more than x
        List<PlayerDto> playerListWithAvgMoreThanX = playerList.stream().filter(p-> p.getAverageScore() > x).map(p -> this.modelMapper.map(p, PlayerDto.class)).collect(Collectors.toList());
        return playerListWithAvgMoreThanX;
    }



        @Override
    public String deletePlayerById(Integer playerId)
    {
        Player player = playerRepo.
                findById(playerId).orElseThrow(() -> new ResourceNotFoundException("player not found with ", "playerId :", playerId));
                  playerRepo.delete(player);
                  return "player deleted successfully";
    }

    @Override
    public List<PlayerDto> getPlayersByCountry(String countryName,Integer pageNumber,Integer pageSize)
    {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Player> playerPage = playerRepo.findByCountryName(countryName, pageRequest);
        List<Player> playerListByCountryName = playerPage.getContent();  // returning playersListByCountryName
        return playerListByCountryName.stream().map(p -> this.modelMapper.map(p, PlayerDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PlayerDto> listOfPlayerInSortedOrderWithAvgMoreThanY(Integer y, Integer pageNumber, Integer pageSize)
    {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Player> all = playerRepo.findAll(pageRequest);
        List<Player> playerList = all.getContent();
        List<Player> filteredList= playerList.stream().filter(p -> p.getAverageScore() > y).collect(Collectors.toList());

        // Sort players based on average score and age
        filteredList.sort((p1, p2) -> {
            // First, compare average scores
            int avgScoreComparison = Double.compare(p2.getAverageScore(), p1.getAverageScore());
            if (avgScoreComparison != 0) {
                return avgScoreComparison;
            }

            // If average scores are equal, compare ages
            return Integer.compare(p1.getPlayerAge(), p2.getPlayerAge());
        });

        // Map sorted players to PlayerDto
        List<PlayerDto> sortedPlayerDtos = filteredList.stream()
                .map(player -> modelMapper.map(player, PlayerDto.class))
                .collect(Collectors.toList());
        return sortedPlayerDtos;
    }


    public int calculateAge(Date dob)
   {                                 // calculating age of player from dob to current year dynamically
       LocalDate birthdate = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
       LocalDate currentDate = LocalDate.now();
       return Period.between(birthdate, currentDate).getYears();
   }


}

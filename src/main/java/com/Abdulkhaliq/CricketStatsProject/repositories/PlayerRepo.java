package com.Abdulkhaliq.CricketStatsProject.repositories;

import com.Abdulkhaliq.CricketStatsProject.entities.Matches;
import com.Abdulkhaliq.CricketStatsProject.entities.Player;
import com.Abdulkhaliq.CricketStatsProject.payloads.PlayerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Integer>
{
    // custom query
    Player  findByPlayerName(String PlayerName);
  Page<Player> findByCountryName(String countryName, Pageable pageable); // getting player list by countryName

    List<Matches> findAllMatches(Integer playerId);
}

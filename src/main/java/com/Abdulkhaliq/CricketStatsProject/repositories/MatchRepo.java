package com.Abdulkhaliq.CricketStatsProject.repositories;

import com.Abdulkhaliq.CricketStatsProject.entities.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends JpaRepository<Matches,Integer>
{
    // custom repo
}

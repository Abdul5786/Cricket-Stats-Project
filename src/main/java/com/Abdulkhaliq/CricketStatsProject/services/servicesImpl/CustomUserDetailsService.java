package com.Abdulkhaliq.CricketStatsProject.services.servicesImpl;

import com.Abdulkhaliq.CricketStatsProject.entities.User;
import com.Abdulkhaliq.CricketStatsProject.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService
{

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepo.findByEmail(username).orElseThrow(() -> new RuntimeException("user Not Found with email :" + username));
         return user;
    }
}

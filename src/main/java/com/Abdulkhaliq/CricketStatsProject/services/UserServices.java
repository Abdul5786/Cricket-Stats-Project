package com.Abdulkhaliq.CricketStatsProject.services;

import com.Abdulkhaliq.CricketStatsProject.entities.User;
import com.Abdulkhaliq.CricketStatsProject.payloads.Roles;
import com.Abdulkhaliq.CricketStatsProject.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices
{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;
    public User createUser(User user)
    {
        // create User
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Roles.USER);
        User savedUser = userRepo.save(user);
        return   savedUser;
    }
    public User createUserAdmin(User user)
    {
        // creating ADMIN User
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Roles.ADMIN.ADMIN);
        User savedUser = userRepo.save(user);
        return   savedUser;
    }

    public List<User> getAllUser()
    {
        List<User> all = userRepo.findAll();
        return all;
    }
}

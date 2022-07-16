package com.disney.disneyproject.securityBad.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.disney.disneyproject.securityBad.entities.User;
import com.disney.disneyproject.securityBad.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public Optional<User> GetUserByName(String userName){
        return userRepository.findByUserName(userName);
    }
    public boolean ExistByUserName(String userName){
        return userRepository.existsByUserName(userName);
    }
    public void SaveUser(User user){
        userRepository.save(user);
    }
}

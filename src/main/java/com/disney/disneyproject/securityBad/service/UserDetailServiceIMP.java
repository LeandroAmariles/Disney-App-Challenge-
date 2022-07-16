package com.disney.disneyproject.securityBad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.disney.disneyproject.securityBad.entities.MainUser;
import com.disney.disneyproject.securityBad.entities.User;

@Service
public class UserDetailServiceIMP {

    private final UserService userService;

    @Autowired
    public UserDetailServiceIMP(UserService userService) {
        this.userService = userService;
    }

    public UserDetails LoadUserByUsername(String userName) throws UsernameNotFoundException{
        User user = userService.GetUserByName(userName).get();
        return MainUser.Build(user);
    }
}

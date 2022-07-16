package com.disney.disneyproject.securityBad.controller;

import com.disney.disneyproject.securityBad.DTO.LoginUser;
import com.disney.disneyproject.securityBad.DTO.NewUser;
import com.disney.disneyproject.securityBad.DTO.jwtDTO;
import com.disney.disneyproject.securityBad.entities.Role;
import com.disney.disneyproject.securityBad.entities.User;
import com.disney.disneyproject.securityBad.enums.RoleList;
import com.disney.disneyproject.securityBad.jwt.JwtProvider;
import com.disney.disneyproject.securityBad.service.RoleService;
import com.disney.disneyproject.securityBad.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    private final RoleService roleService;

    private final JwtProvider jwtProvider;



    @Autowired
    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder, PasswordEncoder passwordEncoder, UserService userService, RoleService roleService, JwtProvider jwtProvider) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.roleService = roleService;
        this.jwtProvider = jwtProvider;

    }

    @PostMapping("/login")
    public ResponseEntity<Object> Login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(new MessageFormat("Check your credential"), HttpStatus.BAD_REQUEST);
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword());
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            jwtDTO jwtDTO = new jwtDTO(jwt);
            return new ResponseEntity<>(jwtDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageFormat("Check your credential"), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new MessageFormat("Check the fields again"), HttpStatus.BAD_REQUEST);
        User user = new User(newUser.getUserName(), newUser.getMail(),passwordEncoder.encode(newUser.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.GetByRoleName(RoleList.USER).get());
        if(newUser.getRoles().contains("admin"))
            roles.add(roleService.GetByRoleName(RoleList.ADMIN).get());
            user.setRoles(roles);
            userService.SaveUser(user);
        return new ResponseEntity<>(new MessageFormat("Register successful "),HttpStatus.CREATED);
    }
}

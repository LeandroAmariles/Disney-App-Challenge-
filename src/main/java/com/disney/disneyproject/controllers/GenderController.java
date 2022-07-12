package com.disney.disneyproject.controllers;

import com.disney.disneyproject.DTO.GenderDTO;
import com.disney.disneyproject.service.GenderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GenderController {

    @Autowired
    private GenderService genderService;

    @PostMapping("/Gender")
    public ResponseEntity<GenderDTO> SaveNewGender(@RequestBody GenderDTO genderDTO){
        return ResponseEntity.ok(genderService.CreateGender(genderDTO));
    }

}

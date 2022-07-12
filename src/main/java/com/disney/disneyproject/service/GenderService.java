package com.disney.disneyproject.service;

import com.disney.disneyproject.DTO.GenderDTO;
import com.disney.disneyproject.repository.GenderRepository;

public interface GenderService{

    public GenderDTO CreateGender(GenderDTO genderDTO);
}

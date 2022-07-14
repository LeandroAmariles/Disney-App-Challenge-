package com.disney.disneyproject.service;

import com.disney.disneyproject.DTO.GenderDTO;
import com.disney.disneyproject.entities.Gender;
import com.disney.disneyproject.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceIMP implements GenderService{

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private Mapper mapper;


    @Override
    public GenderDTO CreateGender(GenderDTO genderDTO) {
        Gender gender = mapper.MappingToEntity(genderDTO);
        genderRepository.save(gender);
        return genderDTO;
    }

}

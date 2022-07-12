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


    @Override
    public GenderDTO CreateGender(GenderDTO genderDTO) {
        Gender gender = MappingToEntity(genderDTO);
        genderRepository.save(gender);
        return genderDTO;
    }

    private GenderDTO MappingToDTO(Gender gender){
        GenderDTO genderDTO = new GenderDTO();
        genderDTO.setGenderId(gender.getPkGenderId());
        genderDTO.setName(gender.getName());

        return genderDTO;
    }

    private Gender MappingToEntity(GenderDTO genderDTO){
        Gender gender = new Gender();
        gender.setName(genderDTO.getName());
        gender.setPkGenderId(genderDTO.getGenderId());
        return gender;
    }
}

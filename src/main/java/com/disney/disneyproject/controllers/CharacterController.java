package com.disney.disneyproject.controllers;

import com.disney.disneyproject.DTO.CharacterDTO;
import com.disney.disneyproject.entities.Character;
import com.disney.disneyproject.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/list")
    public ResponseEntity<Set<CharacterDTO>> GettingCharacters(){
        return ResponseEntity.ok(characterService.GetCharacterList());
    }

    @PostMapping("/save")
    public ResponseEntity<CharacterDTO> SaveNewCharacter(@RequestBody CharacterDTO characterDTO){
        return ResponseEntity.ok(characterService.CreateCharcarter(characterDTO));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CharacterDTO>  UpdateCharacter(@PathVariable long id, @RequestBody CharacterDTO characterDTO){
        return ResponseEntity.ok(characterService.UpdateCharcter(id,characterDTO));
    }
    @DeleteMapping("/delete/{id}")
    public void DeleteCharacter(@PathVariable long id){
        characterService.DeleteCharacterById(id);
    }


}

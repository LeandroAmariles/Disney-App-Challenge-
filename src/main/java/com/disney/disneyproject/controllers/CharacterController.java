package com.disney.disneyproject.controllers;

import com.disney.disneyproject.DTO.CharacterANS;
import com.disney.disneyproject.DTO.CharacterDTO;
import com.disney.disneyproject.DTO.CharacterFilter;
import com.disney.disneyproject.entities.Character;
import com.disney.disneyproject.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping()
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/list")
    public ResponseEntity<Set<CharacterDTO>> GettingCharacters(){
        return ResponseEntity.ok(characterService.GetCharacterList());
    }

    @PostMapping("/save")
    public ResponseEntity<CharacterANS> SaveNewCharacter(@RequestBody CharacterANS characterANS){
        return ResponseEntity.ok(characterService.CreateCharcarter(characterANS));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CharacterANS>  UpdateCharacter(@PathVariable long id, @RequestBody CharacterDTO characterDTO){
        return ResponseEntity.ok(characterService.UpdateCharcter(id,characterDTO));
    }
    @DeleteMapping("/delete/{id}")
    public void DeleteCharacter(@PathVariable long id){
        characterService.DeleteCharacterById(id);

    }
    @GetMapping("/character_details/{id}")
    public ResponseEntity<CharacterANS> CharacterDetails(@PathVariable long id){
        return new ResponseEntity<>(characterService.CharacterDetails(id), HttpStatus.OK);
    }

    @GetMapping("/characters/{name}/{age}/{movieId}")
    public ResponseEntity<Set<CharacterFilter>> filter(@PathVariable String name,@PathVariable int age, @PathVariable long movieId){
        if( name == null &&  age != 0  && movieId == 0){
            return ResponseEntity.ok(characterService.findByAge(age));
        }
        else if (name!=null && age == 0 && movieId == 0) {
            return ResponseEntity.ok(characterService.findByName(name));
        }
        else {
            return ResponseEntity.ok(characterService.GetCharactersFilter());
        }

    }




}

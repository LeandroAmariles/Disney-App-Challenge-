package com.disney.disneyproject.service;

import com.disney.disneyproject.DTO.CharacterDTO;
import com.disney.disneyproject.exceptions.ResourceNotFoundException;
import com.disney.disneyproject.repository.CharacterRepository;
import com.disney.disneyproject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.disney.disneyproject.entities.Character;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CharacterServiceIMP implements CharacterService{

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public CharacterDTO CreateCharcarter(CharacterDTO characterDTO) {
        Character newCharcater= mappingEntity(characterDTO);

        Character Character1=characterRepository.save(newCharcater);

        CharacterDTO characterDTO1=mappingDTO(newCharcater);

        return characterDTO1;

    }

    @Override
    public CharacterDTO UpdateCharcter(Long characterId, CharacterDTO characterSolicited) {
        Character character = characterRepository.findById(characterId).orElseThrow(()->new ResourceNotFoundException("Character","id",characterId));
        character.setName(characterSolicited.getName());
        character.setImage(characterSolicited.getImage());
        character.setHistory(characterSolicited.getHistory());
        character.setAge(characterSolicited.getAge());
        character.setWeiht(characterSolicited.getWeiht());

        characterRepository.save(character);

        CharacterDTO characterDTO=mappingDTO(character);
        return characterDTO;
    }

    @Override
    public void DeleteCharacterById(Long characterId) {
        characterRepository.deleteById(characterId);
    }

    @Override
    public Set<CharacterDTO> GetCharacterList() {

        List<Character> list = characterRepository.findAll();
        Set<CharacterDTO> listDTO = list.stream().map(character -> mappingDTO(character)).collect(Collectors.toSet());
        return listDTO;
    }

    @Override
    public CharacterDTO CharacterDetails(long id) {
        Character character= characterRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Character","id",id));
        character.setMovies(characterRepository.findById(id).get().getMovies());
        CharacterDTO characterDTO = mappingDTO(character);

        return characterDTO;
    }

    private Character mappingEntity(CharacterDTO character){
        Character newCharacter = new Character();
        newCharacter.setPkCharacterId(character.getPkCharacterId());
        newCharacter.setName(character.getName());
        newCharacter.setWeiht(character.getWeiht());
        newCharacter.setAge(character.getAge());
        newCharacter.setHistory(character.getHistory());
        newCharacter.setImage(character.getImage());
        return newCharacter;
    }

    private CharacterDTO mappingDTO(Character character){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setPkCharacterId(character.getPkCharacterId());
        characterDTO.setAge(character.getAge());
        characterDTO.setHistory(character.getHistory());
        characterDTO.setImage(character.getImage());
        characterDTO.setName(character.getName());
        characterDTO.setWeiht(characterDTO.getWeiht());
        return characterDTO;
    }
}

package com.disney.disneyproject.service;

import com.disney.disneyproject.DTO.CharacterANS;
import com.disney.disneyproject.DTO.CharacterDTO;
import com.disney.disneyproject.DTO.CharacterFilter;
import com.disney.disneyproject.entities.Character;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface CharacterService {

    public CharacterANS CreateCharcarter(CharacterANS Character);

    public CharacterANS UpdateCharcter(Long characterId, CharacterDTO characterSolicited);

    public void DeleteCharacterById(Long characterId);

    public Set<CharacterDTO> GetCharacterList();

    public CharacterANS CharacterDetails(long id);

    public Set<CharacterFilter> findByName(String name);

    public Set<CharacterFilter> findByAge(int Age);

    public Set<CharacterFilter> GetCharactersFilter();



}
